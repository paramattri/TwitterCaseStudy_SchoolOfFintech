package com.twittercasestudy.dao.jdbc

import com.twittercasestudy.dao.TweetDao
import java.lang.Exception
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.Statement

class JdbcTweetDao : TweetDao {

    private val connectionHelper = ConnectionHelper()

    override fun createTweetTable() {

        var conn : Connection? = null
        var stmt : Statement? = null

        try {
            conn = connectionHelper.getConnection()
            if (conn != null) {
                stmt = conn.createStatement()
            }
            connectionHelper.useDatabase(stmt)

            val sql = """
            CREATE TABLE IF NOT EXISTS tweets (
            username VARCHAR(255) NOT NULL,
            tweet VARCHAR(255) NOT NULL,
            created_time VARCHAR(255) NOT NULL)
        """.trimIndent()

            stmt?.execute(sql)

        }catch (e : Exception){
            println(e.message)
        }finally {
            connectionHelper.cleanUp(conn, stmt, rs = null)
        }
    }

    override fun insertTweet(tweet: String, userName : String, createdTime : String) {

        var conn : Connection? = null
        var stmt : PreparedStatement? = null
        try {
            conn = connectionHelper.getConnection()

            val stmt1 : Statement? = conn?.createStatement()
            connectionHelper.useDatabase(stmt1)

            val sql: String = "INSERT INTO tweets VALUES (?, ?, ?)";
            stmt = conn?.prepareStatement(sql);

            stmt?.setString(1, userName)
            stmt?.setString(2, tweet)
            stmt?.setString(3, createdTime)

            stmt?.executeUpdate()

        }catch (e : Exception){
            println(e.message)
        }finally {
            connectionHelper.cleanUp(conn, stmt, rs = null)
        }
    }

    override fun deleteTweet(tweet: String, userName: String) {

        var conn : Connection? = null
        var stmt : Statement? = null

        try {
            conn = connectionHelper.getConnection()
            val sql : String = "DELETE FROM tweets WHERE tweet = '$tweet' AND username = '$userName'"
            stmt = conn?.createStatement()
            connectionHelper.useDatabase(stmt)
            stmt?.execute(sql)

        }catch (e : Exception){
            println(e.message)
        }finally {
            connectionHelper.cleanUp(conn, stmt, rs = null)
        }
    }

    override fun displayTweet(userName: String) {

        var conn : Connection? = null
        var stmt : Statement? = null
        var rs : ResultSet? = null

        try {
            conn = connectionHelper.getConnection()
            val sql : String = "SELECT * FROM tweets WHERE username = '$userName'"
            if (conn != null) {
                stmt = conn.createStatement()
            }
            connectionHelper.useDatabase(stmt)
            rs = stmt?.executeQuery(sql)
            if (rs != null) {
                while (rs.next()){
                    println("UserName: "+rs.getString("username")+"\tTweet: "+rs.getString("tweet")+"\tCreation Time: "+rs.getString("created_time"))
                }
            }
        }catch (e : Exception){
            println(e.message)
        }finally {
            connectionHelper.cleanUp(conn, stmt, rs)
        }
    }

    override fun updateTweet(tweetOld: String, tweetNew: String, userName: String) {

        var conn : Connection? = null
        var stmt : Statement? = null

        try {
            conn = connectionHelper.getConnection()
            val sql : String = """
            UPDATE tweets 
            SET tweet = '$tweetNew'
            WHERE tweet = '$tweetOld' AND username = '$userName'
        """.trimIndent()

            if (conn != null) {
                stmt = conn.createStatement()
            }
            connectionHelper.useDatabase(stmt)
            stmt?.execute(sql)

        }catch (e : Exception){
            println(e.message)
        }finally {
            connectionHelper.cleanUp(conn, stmt, rs = null)
        }
    }

    override fun trendingTweets() {

        var conn : Connection? = null
        var stmt : Statement? = null
        var rs : ResultSet? = null

        try {
            conn = connectionHelper.getConnection()
            val sql : String = """
            SELECT tweet, COUNT(tweet) AS count
            FROM tweets
            GROUP BY tweet
            ORDER BY count DESC
        """.trimIndent()
            if (conn != null) {
                stmt = conn.createStatement()
            }
            connectionHelper.useDatabase(stmt)
            rs = stmt?.executeQuery(sql)

            if (rs != null) {
                while (rs.next()){
                    println("Tweet: "+rs.getString("tweet")+"\t---> "+rs.getString("count"))
                }
            }
        }catch (e : Exception){
            println(e.message)
        }finally {
            connectionHelper.cleanUp(conn, stmt, rs)
        }
    }

}