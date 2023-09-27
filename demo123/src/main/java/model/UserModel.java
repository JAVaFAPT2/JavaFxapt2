package model;

import common.ICommon;
import entity.User;
import dao.JDBCConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class UserModel implements ICommon<User>{
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;

    public void setValueForUser(User User) throws SQLException {
        User.setId(rs.getInt("id"));
        User.setName(rs.getString("name"));
        User.setPhone(rs.getString("phone"));
    }

    public void setValueForParam(PreparedStatement ps, User User) throws SQLException {
        User.setId(rs.getInt("id"));
        User.setName(rs.getString("name"));
        User.setPhone(rs.getString("phone"));
    }

    @Override
    public ArrayList<User> getAll() {
        ArrayList<User> arrayList = new ArrayList<>();
        String sql = "SELECT * FROM User";
        try {
            //Connection success
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                User User = new User();
                setValueForUser(User);
                arrayList.add(User);
            }JDBCConnect.close();
            return arrayList;

        } catch (SQLException e) {
        } finally {
            JDBCConnect.close();
        }
        return null;
    }

    @Override
    public User getOne(int id) {
        String sql = "SELECT * FROM User where id = ?";
        try {
            //Connection success
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();
            User User = new User();
            if (rs.next()) {
                setValueForUser(User);
            }JDBCConnect.close();
            return User;
        } catch (SQLException ignored) {
        } finally {
            JDBCConnect.close();
        }
        return null;
    }

    @Override
    public boolean add(User obj) {
        int flag = 0;
        String UpdateTableSQL = "INSERT INTO User"
                + "(name, phone) VALUE"
                + "(?,?)";
        try (Connection con = JDBCConnect.getJDBCConnection();
             PreparedStatement ps = con.prepareStatement(UpdateTableSQL))  {
            ps.setString(1, obj.getName());
            ps.setString(2, obj.getPhone());
            flag = ps.executeUpdate();
            System.out.println("Record is insert into DBUSER table !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        JDBCConnect.close();
        return flag > 0;
    }

    @Override
    public boolean update(User User, int id) {
        int flag = 0;
        String UpdateTableSQL = "UPDATE User SET name = ?, phone = ?"
                + "where id = ?";
        try (Connection con = JDBCConnect.getJDBCConnection();
             PreparedStatement ps = con.prepareStatement(UpdateTableSQL))  {
            new UserModel().setValueForParam(ps, User);
            ps.setInt(3, id);
            //execute update SQL statement
            flag = ps.executeUpdate();
            System.out.println("Record is insert into DBUSER table !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        JDBCConnect.close();
        return flag > 0;
    }

    @Override
    public boolean delete(int id) {
        int flag = 0;
        if (Objects.isNull(new UserModel().getOne(id))) {
            System.out.println("Not Found Object to Delete");
            return false;
        } else {
            String DeleteTableSQL = "DELETE FROM User WHERE id = ?";
            try (Connection con = JDBCConnect.getJDBCConnection();
                 PreparedStatement ps = con.prepareStatement(DeleteTableSQL)) {
                ps.setInt(1, id);
                //execute update SQL statement
                flag = ps.executeUpdate();
                System.out.println("Record is delete!");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        JDBCConnect.close();
        return flag > 0;
    }

}