package com.twittercasestudy.controller

import com.twittercasestudy.model.User
import com.twittercasestudy.service.LoginService
import com.twittercasestudy.service.impl.LoginServiceImpl
import com.twittercasestudy.util.CurrentUserNameUtil
import java.lang.Exception
import java.util.*

class LoginController {

    private val loginServiceImpl : LoginService = LoginServiceImpl()
    private val read = Scanner(System.`in`)
    var userName : String = ""

    fun loginValidate() : Boolean{
        try {
            println("Enter UserName: ")
            userName = read.nextLine()

            println("Enter Password: ")
            val password: String = read.nextLine()

            CurrentUserNameUtil.setCurrentUserName(userName)

            return loginServiceImpl.loginValidate(userName, password)

        }catch (e : Exception){
            println(e.message)
        }
        return false
    }
}