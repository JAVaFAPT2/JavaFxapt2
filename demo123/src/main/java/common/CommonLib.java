package common;

import dao.JDBCConnect;
import model.UserModel;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class CommonLib {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet rs;

    public static boolean getFlag( String table,int id) {
        boolean result = false;
        int flag;
        String DeleteTableSQL = "DELETE FROM ? WHERE id = ?";
        try (Connection con = JDBCConnect.getJDBCConnection()) {
            assert con != null;
            try (PreparedStatement ps = con.prepareStatement(DeleteTableSQL)) {
                ps.setString(1, table);
                ps.setInt(2, id);
                //execute update SQL statement
                flag = ps.executeUpdate();
                System.out.println("Record is delete!");
                if(flag>0) result = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public ResultSet getAll(String table) {
        String sql = "SELECT * FROM ?";
        try {
            // Connection success
            connection = JDBCConnect.getJDBCConnection();
            assert connection != null;
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, table);
            rs = preparedStatement.executeQuery();
            return rs;
        } catch (SQLException ignored) {
        } finally {
            JDBCConnect.close(connection,rs,preparedStatement);
        }
        return null;
    }

    public ResultSet getOne(String table,int id){

        String sql = "SELECT * FROM ? where id = ?";
        try {
            // Connection success
            connection = JDBCConnect.getJDBCConnection();
            assert connection != null;
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, table);
            preparedStatement.setInt(2, id);
            rs = preparedStatement.executeQuery();
            return rs;
        } catch (SQLException ignored) {
        } finally {
            JDBCConnect.close(connection,rs,preparedStatement);
        }
        return null;
    }
}
