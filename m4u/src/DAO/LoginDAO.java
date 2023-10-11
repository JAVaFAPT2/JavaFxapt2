/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.User;


public class LoginDAO extends ConnectSQL {

    /**
     * Gets user by user name.
     *
     * @param username the username
     * @return the user by user name
     */
    public static User getUserByUserName(String username) {
        User user = null;
        open();

        try {
            String sql = "SELECT * FROM UserAccount WHERE username = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, username);

            // Thực thi truy vấn
            ResultSet resultSet = statement.executeQuery();

            // Kiểm tra kết quả truy vấn
            if (resultSet.next()) {
                // Lấy thông tin từ ResultSet và tạo đối tượng User tương ứng
                int userAccount_id = resultSet.getInt("userAccount_id");
                int userId = resultSet.getInt("user_id");
                String password = resultSet.getString("password");
                int role = resultSet.getInt("role");

                user = new User(userAccount_id, userId, username, password, role);
            }
        } catch (SQLException e) {
        }
        close();
        return user;
    }

    /**
     * Search list.
     *
     * @param searchValue the search value
     * @return the list
     */
    public static List<User> search(String searchValue) {
        List<User> dataList = new ArrayList<>();

        open();

        try {
            String sql = "SELECT * FROM useraccount WHERE concat(user_id, username) LIKE ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + searchValue + "%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("userAccount_id"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getInt("role")
                );
                dataList.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        close();
        return dataList;
    }

    /**
     * Gets max.
     *
     * @return the max
     */
    public int getMax() {
        int id = 0;
        open();
        String sql = "select max(userAccount_id) from useraccount";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return id + 1;
    }

    /**
     * Select list.
     *
     * @return the list
     */
    public static List<User> select() {
        List<User> dataList = new ArrayList<>();

        open();
        try {

            String sql = "select * from useraccount";
            statement = conn.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("userAccount_id"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getInt("role")
                );
                dataList.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        close();

        return dataList;
    }

    /**
     * Update.
     *
     * @param user the user
     */
    public static void update(User user) {
        open();
        try {
            String sql = "update useraccount set user_id = ?, username = ?, password =?, role = ?  where userAccount_id = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, user.getUser_id());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getRole());
            statement.setInt(5, user.getId());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(StudentsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    public static void delete(int id) {
        open();
        try {

            String sql = "delete from useraccount where userAccount_id = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }

    /**
     * Insert.
     *
     * @param user the user
     */
    public static void insert(User user) {
        open();
        try {

            String sql = "insert into useraccount (user_id, username, password, role) values (?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, user.getUser_id());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getRole());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }

    /**
     * Is id exits boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public boolean isIDExits(int id) {
        open();
        try {
            String sql = "select * from useraccount where user_id = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return false;
    }
}
