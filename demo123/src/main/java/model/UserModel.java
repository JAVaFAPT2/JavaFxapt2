package model;

import common.CommonLib;
import common.ICommon;
import entity.Account;
import entity.User;
import dao.JDBCConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class UserModel implements ICommon<User>{
    private CommonLib commonLib;
    private static final String table="user";
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;

    public void setValueForUser(User User) throws SQLException {
        User.setId(rs.getInt("id"));
        User.setName(rs.getString("name"));
        User.setPhone(rs.getString("phone"));
    }

    public void setValueForParam(PreparedStatement ps, User User) throws SQLException {
        ps.setInt(1,User.getId());
        ps.setString(2,User.getName());
        ps.setString(3, User.getPhone());
    }

    @Override
    public ArrayList<User> getAll() {
        ArrayList<User> arrayList = new ArrayList<>();
        rs= commonLib.getAll(table);
        try{
            while (rs.next()) {
                User User = new User();
                arrayList.add(User);
            }
        }catch (SQLException ignored){}
        return arrayList;
    }

    @Override
    public User getOne(int id) {
        rs = commonLib.getOne(table,id);
        User User = new User();
        try {
            if (rs.next()) setValueForUser(User);
        } catch (SQLException ignored) {
        }
        return User;
    }

    @Override
    public boolean add(User User) {
        int flag = 0;
        String UpdateTableSQL = "INSERT INTO User"
                + "(name, phone) VALUE"
                + "(?,?)";
        try (Connection con = JDBCConnect.getJDBCConnection()) {
            assert con != null;
            try (PreparedStatement ps = con.prepareStatement(UpdateTableSQL))  {
                new UserModel().setValueForParam(ps, User);
                flag = ps.executeUpdate();
                System.out.println("Record is inserted!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        JDBCConnect.close(connection,rs,preparedStatement);
        return flag > 0;
    }

    @Override
    public boolean update(User User, int id) {
        int flag = 0;
        String UpdateTableSQL = "UPDATE User SET name = ?, phone = ?"
                + "where id = ?";
        try (Connection con = JDBCConnect.getJDBCConnection()) {
            assert con != null;
            try (PreparedStatement ps = con.prepareStatement(UpdateTableSQL))  {
                new UserModel().setValueForParam(ps, User);
                ps.setInt(3, id);
                //execute update SQL statement
                flag = ps.executeUpdate();
                System.out.println("Record is updated!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        JDBCConnect.close(connection,rs,preparedStatement);
        return flag > 0;
    }

    @Override
    public boolean delete(int id) {
        boolean flag ;
        if (Objects.isNull(new UserModel().getOne(id))) {
            System.out.println("Not Found Object to Delete");
            return false;
        } else {
            flag = CommonLib.getFlag(table, id);
        }
        JDBCConnect.close(connection,rs,preparedStatement);
        return flag ;
    }

}