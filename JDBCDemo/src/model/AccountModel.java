package model;

import common.ICommon;
import entity.Account;
import dao.JDBCConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class AccountModel implements ICommon<Account>{
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;

    public void setValueForAccount(Account Account) throws SQLException {
        Account.setId(rs.getInt("id"));
        Account.setName(rs.getString("name"));
        Account.setPassword(rs.getString("phone"));
        Account.setAccountType(rs.getString("Account_type"));
        Account.setUserId(rs.getInt("user_id"));
    }

    public void setValueForParam(PreparedStatement ps, Account Account) throws SQLException {
        Account.setId(rs.getInt("id"));
        Account.setName(rs.getString("name"));
        Account.setPassword(rs.getString("phone"));
        Account.setAccountType(rs.getString("Account_type"));
        Account.setUserId(rs.getInt("user_id"));
    }

    @Override
    public ArrayList<Account> getAll() {
        ArrayList<Account> arrayList = new ArrayList<>();
        String sql = "SELECT * FROM Account";
        try {
            // Connection success
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Account Account = new Account();
                setValueForAccount(Account);
                arrayList.add(Account);
            }
            return arrayList;
        } catch (SQLException ignored) {
        } finally {
            JDBCConnect.closeResultSet(rs);
            JDBCConnect.closePreparedStatement(preparedStatement);
            JDBCConnect.closeConnection(connection);
        }
        return null;
    }

    @Override
    public Account getOne(int id) {
        String sql = "SELECT * FROM Account where id = ?";
        try {
            // Connection success
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();
            Account Account = new Account();
            if (rs.next()) {
                setValueForAccount(Account);
            }
            return Account;
        } catch (SQLException ignored) {
        } finally {
            JDBCConnect.closeResultSet(rs);
            JDBCConnect.closePreparedStatement(preparedStatement);
            JDBCConnect.closeConnection(connection);
        }
        return null;
    }

    @Override
    public boolean add(Account obj) {
        int flag = 0;
        String UpdateTableSQL = "INSERT INTO Account"
                + "(name, password, Account_type, user_id) VALUE"
                + "(?,?,?,?)";
        try (Connection con = JDBCConnect.getJDBCConnection();
             PreparedStatement ps = con.prepareStatement(UpdateTableSQL))  {
            ps.setString(1, obj.getName());
            ps.setString(2, obj.getPassword());
            ps.setString(3, obj.getAccountType());
            ps.setInt(4, obj.getUserId());
            flag = ps.executeUpdate();
            System.out.println("Record is insert into DBUSER table !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return flag > 0;
    }

    @Override
    public boolean update(Account Account, int id) {
        int flag = 0;
        String UpdateTableSQL = "UPDATE user SET name = ?, password = ?, Account_type = ?, user_id = ?"
                + "where id = ?";
        try (Connection con = JDBCConnect.getJDBCConnection();
             PreparedStatement ps = con.prepareStatement(UpdateTableSQL))  {
            new AccountModel().setValueForParam(ps, Account);
            ps.setInt(5, id);
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
        if (Objects.isNull(new AccountModel().getOne(id))) {
            System.out.println("Not Found Object to Delete");
            return false;
        } else {
            String DeleteTableSQL = "DELETE FROM Account WHERE id = ?";
            try (Connection con = JDBCConnect.getJDBCConnection();
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

}