package com.twittercasestudy.controller

import com.twittercasestudy.service.RegistrationService
import com.twittercasestudy.service.impl.RegistrationServiceImpl
import com.twittercasestudy.util.EmailValidateUtil
import java.lang.Exception
import java.util.*

class RegistrationController {

    private val registrationServiceImpl : RegistrationService = RegistrationServiceImpl()
    private val emailValidateUtil = EmailValidateUtil()
    private val read = Scanner(System.`in`)

    fun register() : Boolean{

        var isRegistered = false
        try {
            println("Registration Details: ")
            println("Enter First Name: ")
            val firstName : String = read.nextLine()

            println("Enter Last Name: ")
            val lastName : String = read.nextLine()

            println("Enter UserName: ")
            val userName : String = read.nextLine()

            println("Enter Password: ")
            val password : String = read.nextLine()

            println("Enter Email ID: ")
            val emailId : String = read.nextLine()

            var emailValidated = emailValidateUtil.emailValidate(emailId)
            if (emailValidated){
                registrationServiceImpl.register(firstName, lastName, userName, password, emailId)
                isRegistered = true
            }else{
                println("Please enter a correct Email Address.")
            }

        }catch (e : Exception){
            println(e.message)
        }

        return isRegistered
    }


}