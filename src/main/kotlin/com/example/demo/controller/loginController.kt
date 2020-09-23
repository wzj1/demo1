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

@Controller
class loginController {
    @Resource
    lateinit var jdbc: JdbcTemplate
    @PostMapping(value = ["/main/login"], consumes = ["application/json"])
    @ResponseBody
    fun login(@RequestBody data: BaseData<LoginEntity>): String {
        return LoginSqlUtil.setJdbcTemplate(jdbc).loginStr(data.data)
    }


}