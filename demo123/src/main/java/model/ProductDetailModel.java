package model;

import common.CommonLib;
import common.ICommon;
import dao.JDBCConnect;
import entity.ProductDetail;
import entity.ProductDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class ProductDetailModel implements ICommon<ProductDetail> {
    private static final String table="product_detail";
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;
    private CommonLib commonLib;
    public void setValueForProductDetail(ProductDetail ProductDetail) throws SQLException {
        ProductDetail.setProductDetailId(rs.getInt("product_detail_id"));
        ProductDetail.setProductId(rs.getInt("product_id"));
        ProductDetail.setIngredientId(rs.getInt("ingredient_id"));

    }

    public void setValueForParam(PreparedStatement ps, ProductDetail ProductDetail) throws SQLException {

        ps.setInt(1,ProductDetail.getProductDetailId());
        ps.setInt(2,ProductDetail.getProductId());
        ps.setInt(3,ProductDetail.getIngredientId());
    }

    @Override
    public ArrayList<ProductDetail> getAll() {
        ArrayList<ProductDetail> arrayList = new ArrayList<>();
        rs= commonLib.getAll(table);
        try{
            while (rs.next()) {
                ProductDetail ProductDetail = new ProductDetail();
                arrayList.add(ProductDetail);
            }
        }catch (SQLException ignored){}
        return arrayList;
    }

    @Override
    public ProductDetail getOne(int id) {
        rs = commonLib.getOne(table,id);
        ProductDetail ProductDetail = new ProductDetail();
        try {
            if (rs.next()) setValueForProductDetail(ProductDetail);
        } catch (SQLException ignored) {
        }
        return ProductDetail;
    }


    @Override
    public boolean add(ProductDetail obj) {
        int flag = 0;
        String UpdateTableSQL = "INSERT INTO ProductDetail"
                + "(productId, IngredientId) VALUE"
                + "(?,?)";
        try (Connection con = JDBCConnect.getJDBCConnection()) {
            assert con != null;
            try (PreparedStatement ps = con.prepareStatement(UpdateTableSQL))  {
                ps.setInt(1, obj.getProductId());
                ps.setInt(2, obj.getIngredientId());
                flag = ps.executeUpdate();
                System.out.println("Record is insert!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return flag > 0;
    }

    @Override
    public boolean update(ProductDetail ProductDetail, int id) {
        int flag = 0;
        String UpdateTableSQL = "UPDATE ProductDetail SET productId = ?, IngredientId = ?"
                + "where productDetailId = ?";
        try (Connection con = JDBCConnect.getJDBCConnection()) {
            assert con != null;
            try (PreparedStatement ps = con.prepareStatement(UpdateTableSQL))  {
                new ProductDetailModel().setValueForParam(ps, ProductDetail);
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
        if (Objects.isNull(new ProductDetailModel().getOne(id))) {
            System.out.println("Not Found Object to Delete");
            return false;
        } else {
            flag = CommonLib.getFlag(table, id);
        }
        JDBCConnect.close(connection,rs,preparedStatement);
        return flag ;
    }

}
