package com.twittercasestudy.service.impl

import com.twittercasestudy.dao.LoginDao
import com.twittercasestudy.dao.jdbc.JdbcLoginDao
import com.twittercasestudy.service.LoginService

class LoginServiceImpl : LoginService{

    private val jdbcLoginDao : LoginDao = JdbcLoginDao()

    override fun loginValidate(userName: String, password: String): Boolean {
        return jdbcLoginDao.loginValidate(userName, password)
    }
}