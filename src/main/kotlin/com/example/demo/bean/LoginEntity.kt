package com.example.demo.bean

import org.springframework.stereotype.Repository

@Repository
class LoginEntity {
    //id
    var id:Int = 0
    //登录账号
    lateinit var account:String
    //登录密码
    lateinit var password:String
    var accountName:String?=""
    //登录类型: 0 手机号 1 邮箱账号 2 用户名  3 其他(暂不支持)
    var type:Int= 0

}