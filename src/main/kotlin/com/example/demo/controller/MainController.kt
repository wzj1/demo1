package com.example.demo.controller

import com.example.demo.bean.LoginEntity
import com.example.demo.bean.BaseData
import com.example.demo.dao.LoginSqlUtil
import com.example.demo.dao.sqlutil.FindData
import com.example.demo.dao.sqlutil.UpdateSql
import com.example.demo.returndataUtils.ResultData
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import javax.annotation.Resource

/**
 * Controller类
 */
@Controller
class MainController {

    @Resource
    lateinit var jdbc: JdbcTemplate

    @PostMapping(value = ["/main/login"], consumes = ["application/json"])
    @ResponseBody
    fun login(@RequestBody data: BaseData<LoginEntity>): String {
        // 封装 JDBC处理类
        return LoginSqlUtil.setJdbcTemplate(jdbc).loginStr(data.data)
    }


    @PostMapping(value = ["/main/updatelogin"], consumes = ["application/json"])
    @ResponseBody
    fun updatelogin(@RequestBody data: BaseData<LoginEntity>): String {
        if (data.data != null) {
            // 封装 JDBC处理类
            val findByName = FindData(jdbc).findByName(data.data!!.account)
            when (findByName) {
                0 -> {
                    val updateUserInfo = UpdateSql(jdbc).updateUserInfo(data.data)
                    return if (updateUserInfo == "0") ResultData.success200("注册成功") else ResultData.failure300("注册失败")
                }
                1 -> {
                   return ResultData.failure300("该用户已注册")
                }
                else -> {
                    return ResultData.failure300("注册失败")
                }
            }
        }

        return ResultData.failure300("参数错误")
    }
    @PostMapping(value = ["/main/updateloginpwd"], consumes = ["application/json"])
    @ResponseBody
    fun updateloginPwd(@RequestBody data: BaseData<LoginEntity>): String {
        if (data.data != null) {
            val updateLoginPwd = UpdateSql(jdbc).updateLoginPwd(data.data)
            when (updateLoginPwd) {
                "0" -> return ResultData.success200("修改密码成功")
                else -> return ResultData.failure300("修改密码失败")
            }
        }
        return ResultData.failure300("参数错误")
    }

}