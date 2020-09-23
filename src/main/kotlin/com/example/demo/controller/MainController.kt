package com.example.demo.controller

import com.example.demo.bean.LoginEntity
import com.example.demo.bean.BaseData
import com.example.demo.dao.LoginSqlUtil
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
    //注入 jdbc
    @Resource
    lateinit var jdbc: JdbcTemplate
    //登录  路径  json 格式
    @PostMapping(value = ["/main/login"], consumes = ["application/json"])
    @ResponseBody
    fun login(@RequestBody data: BaseData<LoginEntity>): String {
        // 封装 JDBC处理类
        return LoginSqlUtil.setJdbcTemplate(jdbc).loginStr(data.data)
    }





}