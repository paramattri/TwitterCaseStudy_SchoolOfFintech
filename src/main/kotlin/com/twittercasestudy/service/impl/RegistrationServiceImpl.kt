package com.twittercasestudy.service.impl

import com.twittercasestudy.dao.RegistrationDao
import com.twittercasestudy.dao.jdbc.JdbcRegistrationDao
import com.twittercasestudy.model.User
import com.twittercasestudy.service.RegistrationService

class RegistrationServiceImpl : RegistrationService {

    private val jdbcRegistrationDao : RegistrationDao = JdbcRegistrationDao()

    override fun register(firstName: String, lastName: String, userName: String, password: String, emailId: String) {

        jdbcRegistrationDao.register(firstName, lastName, userName, password, emailId)

    }

}