package com.twittercasestudy.service.impl

import com.twittercasestudy.dao.jdbc.ConnectionHelper

class DataBaseInitializingServiceImpl {

    fun initialize(){
        val connectionHelper = ConnectionHelper()
        connectionHelper.createDatabase()
    }
}