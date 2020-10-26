package com.twittercasestudy.controller

import com.twittercasestudy.service.impl.DataBaseInitializingServiceImpl

class DatabaseInitializingController {

    fun initialize(){
        val dataBaseInitializingServiceImpl = DataBaseInitializingServiceImpl()
        dataBaseInitializingServiceImpl.initialize()
    }
}