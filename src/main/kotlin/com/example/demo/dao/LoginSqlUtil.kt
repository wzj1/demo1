package com.example.demo.dao

import com.example.demo.bean.LoginEntity
import com.example.demo.bean.UserInfo
import com.example.demo.dao.sqlutil.SqlUrl
import com.example.demo.returndataUtils.ResultData
import com.google.gson.Gson
import org.springframework.context.annotation.Bean
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Controller
import org.springframework.stereotype.Service
import javax.annotation.Resource

/**
 * 数据库 操作类
 */
  object LoginSqlUtil {

    lateinit  var jdbc: JdbcTemplate
    fun  setJdbcTemplate(jc: JdbcTemplate):LoginSqlUtil{
        jdbc = jc
        return this
    }

    /**
     * 登录 操作
     * @param login 登录返回的数据
     * 1. 先查询是否有当前用户的登录账号信息
     * 2. 通过登录账号查询用户信息 并返回数据
     */
    fun  loginStr(login:LoginEntity?):String{
        if (login!=null) {
            var loginEntity: MutableList<LoginEntity> =
                    try {
                        jdbc.query(SqlUrl.getLoginSql(login), arrayOf(), BeanPropertyRowMapper<LoginEntity>(LoginEntity::class.java))
                    } catch (e: Exception) {
                        e.printStackTrace()
                        return ResultData.failure300("获取用户账户信息异常~")
                    }
            if (loginEntity.size == 0) {
                return ResultData.failure300("账户不存在!!!")
            }
            for (login in loginEntity.iterator()) {
                if (login.account != login.account) {
                    return ResultData.failure300("用户名或密码错误!!!")
                } else if (login.password != login.password) {
                    return ResultData.failure300("用户名或密码错误!!!")
                } else {
                    val userInfo: MutableList<UserInfo> = try {
                        jdbc.query(SqlUrl.getLoginInfoSql(login.account), arrayOf(), BeanPropertyRowMapper<UserInfo>(UserInfo::class.java))
                    } catch (e: Exception) {
                        e.printStackTrace()
                        return ResultData.failure300("获取用户信息异常!!!")
                    }

                    if (userInfo.size > 0) {
                        return ResultData.success200(Gson().toJson(userInfo[0]), "登录成功")
                    } else {
                        return ResultData.failure300("获取用户信息失败!!!")
                    }
                }
            }
            println("loginEntity 是否成功：$loginEntity")
            println("loginEntity 获取客户端参数：${Gson().toJson(login)}")
        }
        return ResultData.failure300("登录失败")
    }




}