package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import entity.Account;


public class AccountDAO extends JDBCConnect {
    public static List<Account> search(String searchValue) {
        List<Account> dataList = new ArrayList<>();

        getJDBCConnection();

        try {
            String sql = "SELECT * FROM student WHERE concat(id, name,password,accountType,userId) LIKE ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + searchValue + "%");

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Account acc = new Account(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getInt("accountType"),
                        rs.getInt("userId")
                );
                dataList.add(acc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        close();
        return dataList;
    }

    public static List<Account> sortByName() {
        List<Account> dataList = new ArrayList<>();

        getJDBCConnection();
        try {
            //B2. Query du lieu ra
            String sql = "select * from db_account order by name asc";
            statement = conn.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                 Account acc = new Account(
                         rs.getInt("id"),
                         rs.getString("name"),
                         rs.getString("password"),
                         rs.getInt("accountType"),
                         rs.getInt("userId")
                );
                dataList.add(acc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        close();

        return dataList;
    }

    public static List<Account> select() {
        List<Account> dataList = new ArrayList<>();

        getJDBCConnection();
        try {

            String sql = "select * from db_account";
            statement = conn.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Account acc = new Account(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getInt("accountType"),
                        rs.getInt("userId")
                );
                dataList.add(acc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        close();

        return dataList;
    }

    public static void insert(Account acc) {
        getJDBCConnection();
        try {

            String sql = "insert into db_account (id, name, password, accountType, userId) values (?, ?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, acc.getId());
            statement.setString(2, acc.getName());
            statement.setString(3, acc.getPassword());
            statement.setInt(5, acc.getUserId());
            statement.setInt(4, acc.getAccountType());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }

    public static void update(Account acc) {
        getJDBCConnection();
        try {
            String sql = "update acc set id = ?, name = ?, password = ?, userId = ?, accountType = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, acc.getId());
            statement.setString(2, acc.getName());
            statement.setString(3, acc.getPassword());
            statement.setInt(5, acc.getUserId());
            statement.setInt(4, acc.getAccountType());
            statement.execute();

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }

    public static void delete(int id) {
        getJDBCConnection();
        try {

            String sql = "delete from student where id = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }


    public static Account findById(int id) {
        Account acc = null;
        getJDBCConnection();
        try {

            String sql = "select * from db_account where id = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                         acc = new Account(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getInt("accountType"),
                        rs.getInt("userId")
                );

                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        close();

        return acc;
    }


    public boolean isIDExits(int id) {
        getJDBCConnection();
        try {
            String sql = "select * from db_account where student_id = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return false;
    }

}

