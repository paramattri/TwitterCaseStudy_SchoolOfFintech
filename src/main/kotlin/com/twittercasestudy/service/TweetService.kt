package com.twittercasestudy.service

interface TweetService {

    fun insertTweet(tweet : String)
    fun deleteTweet(tweet : String)
    fun displayTweet()
    fun displayTweetByUserName(userName : String)
    fun updateTweet(tweetOld : String, tweetNew : String)
    fun trendingTweets()
}