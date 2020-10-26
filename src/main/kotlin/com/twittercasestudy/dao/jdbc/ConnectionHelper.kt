package com.twittercasestudy.dao.jdbc

import java.sql.*
import java.util.*

class ConnectionHelper {

    private var conn: Connection? = null

    fun getConnection() : Connection? {
        val connectionProps = Properties()
        connectionProps["user"] = "root"
        connectionProps["password"] = "dashingteam"
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance()
            conn = DriverManager.getConnection(
                "jdbc:" + "mysql" + "://" +
                        "localhost" +
                        ":" + "3306" + "/" +
                        "",
                connectionProps)

            return conn

        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } catch (ex: Exception) {
            // handle any errors
            ex.printStackTrace()
        }

        return conn
    }

    fun cleanUp(conn : Connection?, stmt : Statement?, rs : ResultSet?){

        try {
            rs?.close()
            stmt?.close()
            conn?.close()
        }catch (e : Exception){
            println(e.message)
        }
    }

    fun cleanUp(conn : Connection?, stmt : PreparedStatement?, rs : ResultSet?){

        try {
            rs?.close()
            stmt?.close()
            conn?.close()
        }catch (e : Exception){
            println(e.message)
        }
    }

    fun createDatabase(){

        conn = getConnection()
        var stmt : Statement? = null
        stmt = conn?.createStatement()
        stmt?.execute("CREATE DATABASE IF NOT EXISTS testdatabase;")
    }

    fun useDatabase(stmt: Statement?){

        stmt?.execute("use testdatabase;")
    }
}