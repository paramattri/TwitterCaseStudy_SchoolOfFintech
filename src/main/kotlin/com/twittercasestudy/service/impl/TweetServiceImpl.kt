package com.twittercasestudy.service.impl

import com.twittercasestudy.dao.TweetDao
import com.twittercasestudy.dao.jdbc.JdbcTweetDao
import com.twittercasestudy.model.Tweet
import com.twittercasestudy.service.TweetService
import com.twittercasestudy.util.CurrentUserNameUtil

class TweetServiceImpl : TweetService{

    private val jdbcTweetDao : TweetDao = JdbcTweetDao()
    private val currentUserName = CurrentUserNameUtil()

    override fun insertTweet(tweet: String) {
        val tweetObj = Tweet(tweet, currentUserName.getCurrentUserName())
        jdbcTweetDao.createTweetTable()
        jdbcTweetDao.insertTweet(tweetObj.tweet, tweetObj.userName, tweetObj.createdTime)
    }

    override fun deleteTweet(tweet: String) {
        jdbcTweetDao.deleteTweet(tweet, currentUserName.getCurrentUserName())
    }

    override fun displayTweet() {
        jdbcTweetDao.displayTweet(currentUserName.getCurrentUserName())
    }

    override fun displayTweetByUserName(userName: String) {
        jdbcTweetDao.displayTweet(userName)
    }

    override fun updateTweet(tweetOld: String, tweetNew: String) {
        jdbcTweetDao.updateTweet(tweetOld, tweetNew, currentUserName.getCurrentUserName())
    }

    override fun trendingTweets() {
        jdbcTweetDao.trendingTweets()
    }
}