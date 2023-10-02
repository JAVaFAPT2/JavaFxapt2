package dao;

import config.IDBConfig;

import java.sql.*;

public class JDBCConnect {

    public static Connection getJDBCConnection() {
        Connection con ;
        String connectionUrl = "jdbc:mysql://" + IDBConfig.HOSTNAME
                + ":" + IDBConfig.PORT + "/"
                + IDBConfig.DBNAME ;
        System.out.println(connectionUrl);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.println("Where is your MySQL JDBC Driver?");
            return null;
        }
        System.out.println("MySQL JDBC Driver Registered!");
        
        try {
            con = DriverManager.getConnection(connectionUrl, IDBConfig.USERNAME, IDBConfig.PASSWORD);
        } catch (SQLException ex) {
            System.err.println("Connection Failed! Check output console");
            return null;
        }
        return con;
    }

    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("Close Connection fails");
        }
    }

    public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println("Close ResultSet fails");
        }
    }

    public static void closePreparedStatement(PreparedStatement prepare) {
        try {
            if (prepare != null) {
                prepare.close();
            }
        } catch (SQLException e) {
            System.out.println("Close PreparedStatement fails");
        }
    }
    
    public static void close(Connection connection,ResultSet rs,PreparedStatement preparedStatement)  {
        JDBCConnect.closeResultSet(rs);
        JDBCConnect.closePreparedStatement(preparedStatement);
        JDBCConnect.closeConnection(connection);
    }
}
