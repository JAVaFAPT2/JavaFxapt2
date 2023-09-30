package dao;

import entity.Storage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StorageDAO extends JDBCConnect{
    public static List<Storage> search(String searchValue) {
        List<Storage> dataList = new ArrayList<>();

        getJDBCConnection();

        try {
            String sql = "SELECT * FROM db_storage WHERE concat(ingredient_id,ingredient_name, serving_amount) LIKE ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + searchValue + "%");

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Storage stuff = new Storage(
                        rs.getInt("ingredient_id"),
                        rs.getString("ingredient_name"),
                        rs.getInt("serving_amount")
                );
                dataList.add(stuff);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        close();
        return dataList;
    }

    public static List<Storage> sortByName() {
        List<Storage> dataList = new ArrayList<>();

        getJDBCConnection();
        try {
            //B2. Query du lieu ra
            String sql = "select * from db_storage order by ingredient_name asc";
            statement = conn.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Storage stuff = new Storage(
                        rs.getInt("ingredient_id"),
                        rs.getString("ingredient_name"),
                        rs.getInt("serving_amount")
                );
                dataList.add(stuff);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        close();

        return dataList;
    }

    public static List<Storage> select() {
        List<Storage> dataList = new ArrayList<>();

        getJDBCConnection();
        try {

            String sql = "select * from db_storage";
            statement = conn.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Storage stuff = new Storage(
                        rs.getInt("ingredient_id"),
                        rs.getString("ingredient_name"),
                        rs.getInt("serving_amount")
                );
                dataList.add(stuff);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StorageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        close();

        return dataList;
    }

    public static void insert(Storage stuff) {
        getJDBCConnection();
        try {

            String sql = "insert into db_storage (ingredient_id, ingredient_name, serving_amount) values (?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, stuff.getIngredient_id());
            statement.setString(2, stuff.getIngredient_name());
            statement.setInt(3, stuff.getServing_amount());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }

    public static void update(Storage stuff) {
        getJDBCConnection();
        try {
            String sql = "update db_storage set id = ?, name = ?, password = ?, userId = ?, accountType = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, stuff.getIngredient_id());
            statement.setString(2, stuff.getIngredient_name());
            statement.setInt(3, stuff.getServing_amount());
            statement.execute();

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(StorageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }

    public static void delete(int ingredient_id) {
        getJDBCConnection();
        try {

            String sql = "delete from db_storage where ingredient_id = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, ingredient_id);

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }


    public static Storage findById(int ingredient_id) {
        Storage stuff = null;
        getJDBCConnection();
        try {

            String sql = "select * from db_storage where ingredient_id = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, ingredient_id);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                stuff = new Storage(
                        rs.getInt("ingredient_id"),
                        rs.getString("ingredient_name"),
                        rs.getInt("serving_amount")
                );

                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StorageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        close();

        return stuff;
    }


    public boolean isIDExits(int ingredient_id) {
        getJDBCConnection();
        try {
            String sql = "select * from db_storage where ingredient_id = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, ingredient_id);

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
