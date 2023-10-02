package model;

import common.CommonLib;
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
    private static final String table= "account";
    private static CommonLib commonLib;
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;

    public void setValueForAccount(Account Account) throws SQLException {
        Account.setId(rs.getInt("id"));
        Account.setName(rs.getString("account_name"));
        Account.setPassword(rs.getString("password"));
        Account.setAccountType(rs.getInt("account_type"));
        Account.setUserId(rs.getInt("user_id"));
    }

    public void setValueForParam(PreparedStatement ps, Account Account) throws SQLException {
        ps.setString(1, Account.getName());
        ps.setString(2, Account.getPassword());
        ps.setInt(3,Account.getAccountType());
        ps.setInt(4,Account.getUserId());
    }

    @Override
    public ArrayList<Account> getAll() {
        ArrayList<Account> arrayList = new ArrayList<>();
        rs= commonLib.getAll(table);
        try{
            while (rs.next()) {
            Account Account = new Account();
            arrayList.add(Account);
                }
        }
        catch (SQLException ignored){
            System.out.println("Error");
        }
        return arrayList;
    }

    @Override
    public Account getOne(int id) {
        rs = commonLib.getOne(table,id);
        Account Account = new Account();
        try {
            if (rs.next()) setValueForAccount(Account);
        } catch (SQLException ignored) {
        }
        return Account;
    }

    public Account checkAcc(String userName, String password) {
        String sql = "SELECT * FROM Account where account_name = ? and password = ?";
        try {
            // Connection success
            connection = JDBCConnect.getJDBCConnection();
            assert connection != null;
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            rs = preparedStatement.executeQuery();
            Account Account = new Account();
            if (rs.next()) {
                setValueForAccount(Account);
            }
            JDBCConnect.close(connection,rs,preparedStatement);
            return Account;
        } catch (SQLException ignored) {
        } finally {
            JDBCConnect.close(connection,rs,preparedStatement);
        }
        return null;
    }
    @Override
    public boolean add(Account Account) {
        int flag = 0;
        String UpdateTableSQL = "INSERT INTO Account"
                + "(account_name, password, account_type, user_id) VALUE"
                + "(?,?,?,?)";
        try (Connection con = JDBCConnect.getJDBCConnection()) {
            assert con != null;
            try (PreparedStatement ps = con.prepareStatement(UpdateTableSQL))  {
                new AccountModel().setValueForParam(ps, Account);
                flag = ps.executeUpdate();
                System.out.println("Record is insert!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return flag > 0;
    }

    @Override
    public boolean update(Account Account, int id) {
        int flag = 0;
        String UpdateTableSQL = "UPDATE Account SET account_name = ?, password = ?, account_type = ?, user_id = ?"
                + "where account_id = ?";
        try (Connection con = JDBCConnect.getJDBCConnection()) {
            assert con != null;
            try (PreparedStatement ps = con.prepareStatement(UpdateTableSQL))  {
                new AccountModel().setValueForParam(ps, Account);
                ps.setInt(5, id);
                //execute update SQL statement
                flag = ps.executeUpdate();
                System.out.println("Record is insert!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return flag > 0;
    }

    @Override
    public boolean delete(int id) {
        boolean flag ;
        if (Objects.isNull(new AccountModel().getOne(id))) {
            System.out.println("Not Found Object to Delete");
            return false;
        } else {
            flag = CommonLib.getFlag(table, id);
        }
        JDBCConnect.close(connection,rs,preparedStatement);
        return flag ;
    }

}