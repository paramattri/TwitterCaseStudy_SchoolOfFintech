package com.twittercasestudy.model

import java.text.SimpleDateFormat
import java.util.*

class Tweet {

    var userName : String = ""
    var tweet : String = ""
    var createdTime : String = ""

    constructor(tweet : String, userName : String){

        this.tweet = tweet
        this.userName = userName
        this.createdTime = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(Date())

    }


}