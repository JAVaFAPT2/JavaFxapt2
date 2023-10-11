/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.User;

/**
 * The type Connect sql.
 *
 * @author GreenRain
 */
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
     */
    public static void open() {
        try {
            //B1. Ket noi CSDL
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "12345678");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Close.
     */
    public static void close() {
        //B3. Dong ket noi
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

   
}
