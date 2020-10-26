package com.twittercasestudy.dao.jdbc

import com.twittercasestudy.dao.LoginDao
import java.lang.Exception
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.Statement

class JdbcLoginDao : LoginDao{

    private val connectionHelper = ConnectionHelper()

    override fun createLoginTable() {
        var conn : Connection? = null
        var stmt : Statement? = null

        try {
            conn = connectionHelper.getConnection()

            if (conn != null) {
                stmt = conn.createStatement()
            }

            connectionHelper.useDatabase(stmt)

            val sql = """
            CREATE TABLE IF NOT EXISTS login (
            username VARCHAR(255) PRIMARY KEY,
            password VARCHAR(255) NOT NULL)
        """.trimIndent()

            stmt?.execute(sql)

        }catch (e : Exception){
            println(e.message)
        }finally {
            connectionHelper.cleanUp(conn, stmt, rs = null)
        }
    }

    override fun insertLoginDetails(userName: String, password: String) {

        var conn : Connection? = null
        var stmt : PreparedStatement? = null

        try {
            conn = connectionHelper.getConnection()

            val stmt1 : Statement? = conn?.createStatement()
            connectionHelper.useDatabase(stmt1)

            val sql: String = "INSERT INTO login VALUES (?, ?)";
            stmt = conn?.prepareStatement(sql);

            stmt?.setString(1, userName)
            stmt?.setString(2, password)

            stmt?.executeUpdate()

        }catch (e : Exception){
            println(e.message)
        }finally {
            connectionHelper.cleanUp(conn, stmt, rs = null)
        }

    }

    override fun loginValidate(userName: String, password: String) : Boolean{

        var conn : Connection? = null
        var stmt : Statement? = null
        var rs: ResultSet? = null
        var isLoginValidated = false

        try {
            conn = connectionHelper.getConnection()

            val sql: String = "SELECT password FROM login WHERE username = '$userName'"
            if (conn != null) {
                stmt = conn.createStatement()
            }

            connectionHelper.useDatabase(stmt)
            if (stmt != null) {
                rs = stmt.executeQuery(sql)
            }

            if (rs != null) {
                if(!rs.isBeforeFirst)
                    println("Check Your Username")
                else{
                    rs.next()
                    if(password == rs.getString("password")){
                        isLoginValidated = true
                    }
                }
            }

            if(isLoginValidated){
                println("Welcome Back, You are now Logged In!")
            }else{
                println("Check Your Password")
            }
            return isLoginValidated

        }catch (e : Exception){
            println(e.message)
        }finally {
            connectionHelper.cleanUp(conn, stmt, rs)
        }
        return isLoginValidated
    }
}