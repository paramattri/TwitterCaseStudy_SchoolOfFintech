package com.twittercasestudy.app
import com.twittercasestudy.controller.DatabaseInitializingController
import com.twittercasestudy.controller.LoginController
import com.twittercasestudy.controller.RegistrationController
import com.twittercasestudy.controller.TweetController
import java.lang.Exception
import java.util.Scanner
import kotlin.system.exitProcess

fun main(args : Array<String>){

    val databaseInitializingController = DatabaseInitializingController()

    databaseInitializingController.initialize()
    val read = Scanner(System.`in`)

    println("\n")
    println("\t\t\t\t\t\t\t\t\tWelcome to BUZZ (Your Own Twitter)")
    try {
        while (true) {
            println("\n\t\tPress 1 --> Registration \t\t\t  Press 2 --> Login \t\t\t Press 3 --> Exit")
            println("Enter your choice: ")
            val choice = read.nextInt()
            var isLoginValidated = false

            when(choice){

                1 -> {
                    read.nextLine()
                    if (registration())
                        println("Successfully Registered!")
                    else
                        println("Please Register Again")
                }

                2 -> {
                    read.nextLine()
                    isLoginValidated = loginValidate()
                }

                3 -> {
                    println("Thanks for Your Time")
                    println("Exiting....")
                    exitProcess(0)
                }

                else -> println("Enter a Valid Option!")
            }

            if (choice == 1)
                continue

            if (isLoginValidated)
                break
        }
    }catch (e : Exception){
        println(e.message)
    }

    tweetOperations()
}

fun registration() : Boolean{

    val registrationController = RegistrationController()
    return registrationController.register()
}

fun loginValidate() : Boolean{

    val loginController = LoginController()
    return loginController.loginValidate()
}

fun tweetOperations(){

    val tweetController = TweetController()
    val read = Scanner(System.`in`)
    try {
        while (true) {
            println("Choose from the Below Options: ")
            println("1. Insert Tweet\t 2. Delete Tweet\t 3. Display Tweet/Tweets\t 4. Display Tweet By Username\t 5. Update Tweet\t 6. Trending Tweets\t 7. Logout")
            val choice = read.nextInt()
            read.nextLine()

            when(choice){

                1 -> tweetController.insertTweet()
                2 -> tweetController.deleteTweet()
                3 -> tweetController.displayTweet()
                4 -> tweetController.displayTweetByUserName()
                5 -> tweetController.updateTweet()
                6 -> tweetController.trendingTweets()
                7 -> {
                    println("Thanks for Your Time")
                    println("Exiting....")
                    exitProcess(0)
                }

                else -> println("Enter a Valid Option!")
            }
        }
    }catch (e : Exception){
        println(e.message)
    }
}