package com.twittercasestudy.util

class CurrentUserNameUtil {

    companion object{
        private lateinit var currenUserName : String
        fun setCurrentUserName(userName : String){
            this.currenUserName = userName
        }
    }

    fun getCurrentUserName() : String{
        return currenUserName
    }
}