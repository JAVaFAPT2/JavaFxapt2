/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import config.JDBConfig;

public class ConnectSQL {

    /**
     * The Conn.
     */
    static Connection conn = null;
    /**
     * The Statement.
     */
    static PreparedStatement statement = null;

    /**
     * Open.
     *
     * @return
     */
    public static Connection getJDBCConnection() {
        Connection con = null;
        String connectionUrl = "jdbc:mysql://" + JDBConfig.HOSTNAME
                + ":" + JDBConfig.PORT + "/"
                + JDBConfig.DBNAME ;
        System.out.println(connectionUrl);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.println("Where is your MySQL JDBC Driver?");
            return conn;
        }
        System.out.println("MySQL JDBC Driver Registered!");

        try {
            conn = DriverManager.getConnection(connectionUrl, JDBConfig.USERNAME, JDBConfig.PASSWORD);
        } catch (SQLException ex) {
            System.err.println("Connection Failed! Check output console");
            return conn;
        }
        return conn;
    }


    /**
     * Close.
     */
    public static void close() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        statement = null;
        conn = null;
    }


    public static void main(String[] args) {

        System.out.println(ConnectSQL.getJDBCConnection());

    }
}

