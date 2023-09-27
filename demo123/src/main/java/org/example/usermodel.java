package model;

import common.icommon;
import entity.user;
import dao.JDBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class usermodel implements icommon<user>{
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;

    public void setValueForUser(user User) throws SQLException {
        User.setId(rs.getInt("id"));
        User.setName(rs.getString("name"));
        User.setPhone(rs.getString("phone"));
    }

    public void setValueForParan(PreparedStatement ps, user User) throws SQLException {
        User.setId(rs.getInt("id"));
        User.setName(rs.getString("name"));
        User.setPhone(rs.getString("phone"));
    }

    @Override
    public ArrayList<user> getAll() {
        ArrayList<user> arrayList = new ArrayList<>();
        String sql = "SELECT * FROM user";
        try {
            // kết nối được với db
            connection = JDBConnect.getJDBConnect();
            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                user User = new user();
                setValueForUser(User);
                arrayList.add(User);
            }
            return arrayList;
        } catch (SQLException e) {
        } finally {
            JDBConnect.closeResultSet(rs);
            JDBConnect.closePreparedStatement(preparedStatement);
            JDBConnect.closeConnection(connection);
        }
        return null;
    }

    @Override
    public user getOne(int id) {
        String sql = "SELECT * FROM user where id = ?";
        try {
            // kết nối được với db
            connection = JDBConnect.getJDBConnect();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();
            user User = new user();
            if (rs.next()) {
                setValueForUser(User);
            }
            return User;
        } catch (SQLException e) {
        } finally {
            JDBConnect.closeResultSet(rs);
            JDBConnect.closePreparedStatement(preparedStatement);
            JDBConnect.closeConnection(connection);
        }
        return null;
    }

    @Override
    public boolean add(user obj) {
        int flag = 0;
        String UpdateTableSQL = "INSERT INTO user"
                + "(name, phone) VALUE"
                + "(?,?)";
        try (Connection con = JDBConnect.getJDBConnect();
             PreparedStatement ps = con.prepareStatement(UpdateTableSQL))  {
            ps.setString(1, obj.getName());
            ps.setString(2, obj.getPhone());
            flag = ps.executeUpdate();
            System.out.println("Record is insert into DBUSER table !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return flag > 0;
    }

    @Override
    public boolean update(user User, int id) {
        int flag = 0;
        String UpdateTableSQL = "UPDATE user SET name = ?, phone = ?"
                + "where id = ?";
        try (Connection con = JDBConnect.getJDBConnect();
             PreparedStatement ps = con.prepareStatement(UpdateTableSQL))  {
            new usermodel().setValueForParan(ps, User);
            ps.setInt(3, id);
            //execute update SQL statement
            flag = ps.executeUpdate();
            System.out.println("Record is insert into DBUSER table !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return flag > 0;
    }

    @Override
    public boolean delete(int id) {
        int flag = 0;
        if (Objects.isNull(new usermodel().getOne(id))) {
            System.out.println("Not Found Object to Delete");
            return false;
        } else {
            String DeleteTableSQL = "DELETE FROM user WHERE id = ?";
            try (Connection con = JDBConnect.getJDBConnect();
                 PreparedStatement ps = con.prepareStatement(DeleteTableSQL)) {
                ps.setInt(1, id);
                //execute update SQL statement
                flag = ps.executeUpdate();
                System.out.println("Record is delete DBUSER table !");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return flag > 0;
    }

    public static void main(String[] args) {
    }
}