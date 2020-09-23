package com.example.demo.bean

import org.springframework.stereotype.Repository

/**
 * 用户信息
 */
@Repository
class UserEntity {

    var id :Int = 0
    var userName:String?=null
    var userAge:Int=0
    var userSex:String=""
    var userAccount:String=""
    var userPwd:String=""
    var version:String=""
    var name:String=""




    override fun toString(): String {
        val sb =StringBuffer()
        sb.append("userName:$userName\r\n")
        sb.append("userAge:$userAge\r\n")
        sb.append("userSex:$userSex\r\n")
        sb.append("userAccount:$userAccount\r\n")
        sb.append("userPwd:$userPwd\r\n")
        sb.append("version:$version\r\n")

        return sb.toString()
    }
}