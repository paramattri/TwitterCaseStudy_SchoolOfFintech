package com.twittercasestudy.util

import java.util.regex.Pattern

class EmailValidateUtil {

    fun emailValidate(emailId : String) : Boolean{

        val emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$"
        val pat: Pattern = Pattern.compile(emailRegex)
        var emailValidated = pat.matcher(emailId).matches()
        return emailValidated
    }
}