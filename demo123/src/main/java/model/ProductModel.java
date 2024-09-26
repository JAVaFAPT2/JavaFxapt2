package model;

import common.CommonLib;
import common.ICommon;
import dao.JDBCConnect;
import entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class ProductModel implements ICommon<Product> {
    private CommonLib commonLib;
    private static final String table="product";
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;
    public void setValueForProduct(Product Product) throws SQLException {
        Product.setProductId(rs.getInt("product_id"));
        Product.setProductName(rs.getString("product_name"));
        Product.setPrice(rs.getFloat("price"));
    }

    public void setValueForParam(PreparedStatement ps, Product Product) throws SQLException {

        ps.setString(1,Product.getProductName());
        ps.setFloat(2, Product.getPrice());
    }

    @Override
    public ArrayList<Product> getAll() {
        ArrayList<Product> arrayList = new ArrayList<>();
        rs= commonLib.getAll(table);
        try{
            while (rs.next()) {
                Product Product = new Product();
                arrayList.add(Product);
            }
        }catch (SQLException ignored){}
        return arrayList;
    }

    @Override
    public Product getOne(int id) {
        rs = commonLib.getOne(table,id);
        Product Product = new Product();
        try {
            if (rs.next()) setValueForProduct(Product);
        } catch (SQLException ignored) {
        }
        return Product;
    }

    @Override
    public boolean add(Product Product) {
        int flag = 0;
        String UpdateTableSQL = "INSERT INTO Product"
                + "(product_name, price) VALUE"
                + "(?,?)";
        try (Connection con = JDBCConnect.getJDBCConnection()) {
            assert con != null;
            try (PreparedStatement ps = con.prepareStatement(UpdateTableSQL))  {
                new ProductModel().setValueForParam(ps, Product);
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
    public boolean update(Product Product, int id) {
        int flag = 0;
        String UpdateTableSQL = "UPDATE Product SET product_name = ?, price = ?"
                + "where id = ?";
        try (Connection con = JDBCConnect.getJDBCConnection()) {
            assert con != null;
            try (PreparedStatement ps = con.prepareStatement(UpdateTableSQL))  {
                new ProductModel().setValueForParam(ps, Product);
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
        if (Objects.isNull(new ProductModel().getOne(id))) {
            System.out.println("Not Found Object to Delete");
            return false;
        } else {
            flag = CommonLib.getFlag(table, id);
        }
        JDBCConnect.close(connection,rs,preparedStatement);
        return flag ;
    }
}
