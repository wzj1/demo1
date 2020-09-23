package com.example.demo.controller


//@Controller
public class MainController
//    : BaseController {
//    @Resource
//    lateinit var userServer: UserServer
//
//
//    @PostMapping(value = ["/main/login"], consumes = ["application/json"])
//    @ResponseBody
//    override fun login(@RequestBody bean: UserEntity): String? {
//        println("${bean.toString()}")
////        if (!bean.userName.isNullOrBlank()) {
////            val userName = userServer.login(bean.userAccount,bean.userPwd)
//////            if (userName != null) {
////                if (userName.userAccount != bean.userAccount) {
////                    return ResultData.failure300("账号或密码不正确")
////                } else if (userName.userPwd != bean.userPwd) {
////                    return ResultData.failure300("账号或密码不正确")
////                }
////                //登录成功
////                return ResultData.success200(Gson().toJson(userName), "登录成功")
////            } else {
////                //查询失败 或无此用户
////                return ResultData.failure300("用户未注册,请先注册")
////            }
////        } else {
////            return ResultData.failure300("登录失败!!")
////        }
//
//        return ResultData.failure300()
//
//    }
//
//    @PostMapping(value = ["/main/register"], consumes = ["application/json"])
//    @ResponseBody
//    override fun register(@RequestBody bean: UserEntity): String? {
//        println("${bean.toString()}")
//        when (userServer.insetUser(bean)) {
//            0 -> {
//                //登录成功
//                return ResultData.success200("注册成功")
//            }
//            1 -> {
//                //用户已注册
//                return ResultData.failure300("用户已注册")
//            }
//            else -> {
//                //异常 或其他错误 导致 失败
//                return ResultData.failure300("注册失败!!")
//            }
//        }
//    }
//
//    @PostMapping(value = ["/main/updateUser"], consumes = ["application/json"],name = "name")
//    @ResponseBody
//    fun updeteUser(@RequestBody bean: UserEntity): String? {
//        println("${bean.toString()}")
//        return when (val updeteUser = userServer.updeteUser(bean.name,bean)) {
//            null -> {
//                //未注册 或其他错误
//                ResultData.failure300("更改用户信息失败")
//            }
//            else -> {
//
//                //登录成功
//                ResultData.success200(Gson().toJson(updeteUser),"更改用户信息成功")
//            }
//        }
//    }
//
//}