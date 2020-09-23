package com.example.demo.dao.sqlutil

import com.example.demo.bean.LoginEntity
import com.example.demo.bean.UserInfo

/**
 * SQL 语句 拼接类
 */
object SqlUrl {
    private const val  login_Table:String = "logininfo"
    private const val  user_table:String = "user"
    private const val  userinfo_table:String = "userinfo"

    /**
     * 登录 sql
     * @param login  登录类对象
     */
    fun getLoginSql(login:LoginEntity):String{
        var sql:String = "select * from $login_Table where account='${login.account}'"
        println("getLoginSql :$sql")
        return sql
    }

    /**
     * 获取用户信息
     * @param login  登录类对象
     */
    fun getLoginInfoSql(account:String):String{
        var sql:String = "select * from $userinfo_table where account='$account'"
        println("getLoginSql :$sql")
        return sql
    }

    /**
     * 注册账号
     */
    fun getRegisterSql(login: LoginEntity):String{
        var sql:String = "INSERT INTO  $login_Table (account,password,accountName,type) VALUES('${login.account}','${login.password}','${login.accountName}',${login.type})"
        println("getRegisterSql :$sql")
        return sql
    }

    /**
     * 注册用户信息
     */
    fun getRegisterInfoSql(userInfo: UserInfo):String{
        var sql:String = "INSERT INTO  $userinfo_table " +
                "(userName,userAge,userSex,userCardName,userCardID,userEmail,userPhone,userCall,registerAddress)" +
                "VALUES('${userInfo.userName}',${userInfo.userAge},'${userInfo.userSex}','${userInfo.userCardName}'" +
                ",'${userInfo.userCardID}','${userInfo.userEmail}','${userInfo.userPhone}','${userInfo.userCall}','${userInfo.registerAddress}')"
        println("getRegisterInfoSql :$sql")
        return sql
    }




}