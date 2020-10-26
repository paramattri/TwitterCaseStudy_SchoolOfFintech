package com.twittercasestudy.service

interface RegistrationService {
    fun register(firstName : String, lastName : String, userName : String, password : String, emailId : String)
}