package model;

import common.icommon;
import entity.account;
import dao.JDBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class accountmodel implements icommon<account>{
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;

    public void setValueForAccount(account Account) throws SQLException {
        Account.setId(rs.getInt("id"));
        Account.setName(rs.getString("name"));
        Account.setPassword(rs.getString("phone"));
        Account.setAccountType(rs.getString("account_type"));
        Account.setUserId(rs.getInt("user_id"));
    }

    public void setValueForParan(PreparedStatement ps, account Account) throws SQLException {
        Account.setId(rs.getInt("id"));
        Account.setName(rs.getString("name"));
        Account.setPassword(rs.getString("phone"));
        Account.setAccountType(rs.getString("account_type"));
        Account.setUserId(rs.getInt("user_id"));
    }

    @Override
    public ArrayList<account> getAll() {
        ArrayList<account> arrayList = new ArrayList<>();
        String sql = "SELECT * FROM account";
        try {
            // kết nối được với db
            connection = JDBConnect.getJDBConnect();
            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                account Account = new account();
                setValueForAccount(Account);
                arrayList.add(Account);
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
    public account getOne(int id) {
        String sql = "SELECT * FROM account where id = ?";
        try {
            // kết nối được với db
            connection = JDBConnect.getJDBConnect();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();
            account Account = new account();
            if (rs.next()) {
                setValueForAccount(Account);
            }
            return Account;
        } catch (SQLException e) {
        } finally {
            JDBConnect.closeResultSet(rs);
            JDBConnect.closePreparedStatement(preparedStatement);
            JDBConnect.closeConnection(connection);
        }
        return null;
    }

    @Override
    public boolean add(account obj) {
        int flag = 0;
        String UpdateTableSQL = "INSERT INTO account"
                + "(name, password, account_type, user_id) VALUE"
                + "(?,?,?,?)";
        try (Connection con = JDBConnect.getJDBConnect();
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
    public boolean update(account Account, int id) {
        int flag = 0;
        String UpdateTableSQL = "UPDATE user SET name = ?, password = ?, account_type = ?, user_id = ?"
                + "where id = ?";
        try (Connection con = JDBConnect.getJDBConnect();
             PreparedStatement ps = con.prepareStatement(UpdateTableSQL))  {
            new accountmodel().setValueForParan(ps, Account);
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
        if (Objects.isNull(new accountmodel().getOne(id))) {
            System.out.println("Not Found Object to Delete");
            return false;
        } else {
            String DeleteTableSQL = "DELETE FROM account WHERE id = ?";
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