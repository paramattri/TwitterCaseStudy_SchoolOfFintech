package com.twittercasestudy.dao

interface RegistrationDao {
    fun register(firstName : String, lastName : String, userName : String, password : String, emailId : String)
    fun createUserTable()
}