package com.twittercasestudy.dao

interface TweetDao {

    fun createTweetTable()
    fun insertTweet(tweet : String, userName : String, createdTime : String)
    fun deleteTweet(tweet : String, userName: String)
    fun displayTweet(userName: String)
    fun updateTweet(tweetOld : String, tweetNew : String, userName: String)
    fun trendingTweets()
}