package com.twittercasestudy.dao.jdbc

import com.twittercasestudy.dao.RegistrationDao
import java.lang.Exception
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.Statement

class JdbcRegistrationDao : RegistrationDao{

    private val connectionHelper = ConnectionHelper()
    private val jdbcLoginDao = JdbcLoginDao()

    override fun register(firstName: String, lastName: String, userName: String, password: String, emailId: String) {

        createUserTable()
        var conn : Connection? = null
        var stmt : PreparedStatement? = null
        try {

            conn = connectionHelper.getConnection()

            val stmt1 : Statement? = conn?.createStatement()
            connectionHelper.useDatabase(stmt1)

            val sql: String = "INSERT INTO user VALUES (?, ?, ?, ?, ?)"
            stmt = conn?.prepareStatement(sql)

            stmt?.setString(1, firstName)
            stmt?.setString(2, lastName)
            stmt?.setString(3, userName)
            stmt?.setString(4, emailId)
            stmt?.setString(5, password)

            stmt?.executeUpdate()
            jdbcLoginDao.createLoginTable()
            jdbcLoginDao.insertLoginDetails(userName, password)

        }catch (e : Exception){
            println(e.message)
        }finally {
            connectionHelper.cleanUp(conn, stmt, rs = null)
        }

    }

    override fun createUserTable() {

        var conn : Connection? = null
        var stmt : Statement? = null

        try {
            conn = connectionHelper.getConnection()
            if (conn != null) {
                stmt = conn.createStatement()
            }
            connectionHelper.useDatabase(stmt)

            val sql = """
            CREATE TABLE IF NOT EXISTS user (
            firstname VARCHAR(255) NOT NULL,
            lastname VARCHAR(255),
            username VARCHAR(255) PRIMARY KEY,
            email_id VARCHAR(255) NOT NULL,
            password VARCHAR(255) NOT NULL)
        """.trimIndent()
            stmt?.execute(sql)

        }catch (e : Exception){
            println(e.message)
        }finally {
            connectionHelper.cleanUp(conn, stmt, rs = null)
        }
    }
}