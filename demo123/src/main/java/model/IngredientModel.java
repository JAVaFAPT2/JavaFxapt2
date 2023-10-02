package model;

import common.CommonLib;
import common.ICommon;
import dao.JDBCConnect;
import entity.Ingredient;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class IngredientModel implements ICommon<Ingredient> {
    private CommonLib commonLib;
    private static final String table="ingredient";
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;
    public void setValueForIngredient(Ingredient Ingredient) throws SQLException {
        Ingredient.setIngredientId(rs.getInt("id"));
        Ingredient.setIngredientName(rs.getString("ingredient_name"));
        Ingredient.setServingAmount(rs.getInt("servingAmount"));

    }

    public void setValueForParam(PreparedStatement ps, Ingredient Ingredient) throws SQLException {
        ps.setInt(1, Ingredient.getIngredientId());
        ps.setString(2, Ingredient.getIngredientName());
        ps.setInt(3, Ingredient.getServingAmount());

    }
    @Override
    public ArrayList<Ingredient> getAll() {
        ArrayList<Ingredient> arrayList = new ArrayList<>();
        rs= commonLib.getAll(table);
        try{
            while (rs.next()) {
                Ingredient Ingredient = new Ingredient();
                arrayList.add(Ingredient);
            }
        }catch (SQLException ignored){}
        return arrayList;
    }

    @Override
    public Ingredient getOne(int id) {
        rs = commonLib.getOne(table,id);
        Ingredient Ingredient = new Ingredient();
        try {
            if (rs.next()) setValueForIngredient(Ingredient);
        } catch (SQLException ignored) {
        }
        return Ingredient;
    }

    @Override
    public boolean add(Ingredient obj) {
        int flag = 0;
        String UpdateTableSQL = "INSERT INTO Ingredient"
                + "(ingredient_name, serving_amount) VALUE"
                + "(?,?)";
        try (Connection con = JDBCConnect.getJDBCConnection()) {
            assert con != null;
            try (PreparedStatement ps = con.prepareStatement(UpdateTableSQL))  {
                ps.setString(1, obj.getIngredientName());
                ps.setInt(2, obj.getServingAmount());

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
    public boolean update(Ingredient Ingredient, int id) {
        int flag = 0;
        String UpdateTableSQL = "UPDATE Ingredient SET ingredient_name = ?," +
                " serving_amount = ?,"
                + "where id = ?";
        try (Connection con = JDBCConnect.getJDBCConnection()) {
            assert con != null;
            try (PreparedStatement ps = con.prepareStatement(UpdateTableSQL))  {
                new IngredientModel().
                        setValueForParam(ps, Ingredient);
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
        if (Objects.isNull(new IngredientModel().getOne(id))) {
            System.out.println("Not Found Object to Delete");
            return false;
        } else {
            flag = CommonLib.getFlag(table, id);
        }
        JDBCConnect.close(connection,rs,preparedStatement);
        return flag ;
    }
}
