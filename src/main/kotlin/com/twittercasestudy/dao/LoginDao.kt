package com.twittercasestudy.dao

interface LoginDao {
    fun createLoginTable()
    fun insertLoginDetails(userName : String, password : String)
    fun loginValidate(userName: String, password: String) : Boolean
}