package com.twittercasestudy.controller

import com.twittercasestudy.service.TweetService
import com.twittercasestudy.service.impl.TweetServiceImpl
import java.util.*

class TweetController {

    private val tweetServiceImpl : TweetService = TweetServiceImpl()
    private val read = Scanner(System.`in`)

    fun insertTweet(){
        println("Enter the Tweet: ")
        val tweet = read.nextLine()
        tweetServiceImpl.insertTweet(tweet)
    }

    fun deleteTweet(){
        println("Enter the Tweet to be Deleted: ")
        val delTweet = read.nextLine()
        tweetServiceImpl.deleteTweet(delTweet)
    }

    fun displayTweet(){
        tweetServiceImpl.displayTweet()
    }

    fun displayTweetByUserName(){
        println("Enter the UserName for which you wish to see the Tweets: ")
        val userName = read.nextLine()
        tweetServiceImpl.displayTweetByUserName(userName)
    }

    fun updateTweet(){
        println("Enter the tweet which you want to update: ")
        val tweetOld = read.nextLine()
        println("Enter the New Tweet")
        val tweetNew = read.nextLine()
        tweetServiceImpl.updateTweet(tweetOld, tweetNew)
        println("Tweet Updated!")
    }

    fun trendingTweets(){
        tweetServiceImpl.trendingTweets()
    }
}