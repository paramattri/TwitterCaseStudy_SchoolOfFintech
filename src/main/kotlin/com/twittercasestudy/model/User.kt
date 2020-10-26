package com.twittercasestudy.model

class User {

    private var firstName: String = ""
    private var lastName : String = ""
    private var userName : String = ""
    private var password : String = ""
    private var emailId : String = ""

    constructor(firstname: String, lastname : String, userName : String, password : String, emailId : String){

        this.firstName = firstName
        this.lastName = lastName
        this.userName = userName
        this.password = password
        this.emailId = emailId

    }
}