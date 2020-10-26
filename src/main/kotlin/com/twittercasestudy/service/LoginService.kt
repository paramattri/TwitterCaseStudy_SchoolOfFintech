package com.twittercasestudy.service

interface LoginService {
    fun loginValidate(userName : String, password : String) : Boolean
}