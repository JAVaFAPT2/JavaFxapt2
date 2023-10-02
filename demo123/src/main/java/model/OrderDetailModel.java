package model;

import common.CommonLib;
import common.ICommon;
import dao.JDBCConnect;
import entity.OrderDetail;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class OrderDetailModel implements ICommon<OrderDetail> {
    private CommonLib commonLib;
    private static final String table="order_detail";
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;
    public void setValueForOrderDetail(OrderDetail OrderDetail) throws SQLException {
        OrderDetail.setOrderDetailId(rs.getInt("order_detail_id"));
        OrderDetail.setOrderDetailId(rs.getInt("order_id"));
        OrderDetail.setProductId(rs.getInt("product_id"));
        OrderDetail.setQuantity(rs.getInt("quantity"));
    }

    public void setValueForParam(PreparedStatement ps, OrderDetail OrderDetail) throws SQLException {
        ps.setInt(1,OrderDetail.getOrderId());
        ps.setInt(2,OrderDetail.getProductId());
        ps.setInt(3,OrderDetail.getQuantity());
    }
    @Override
    public ArrayList<OrderDetail> getAll() {
        ArrayList<OrderDetail> arrayList = new ArrayList<>();
        rs= commonLib.getAll(table);
        try{
            while (rs.next()) {
                OrderDetail OrderDetail = new OrderDetail();
                arrayList.add(OrderDetail);
            }
        }catch (SQLException ignored){}
        return arrayList;
    }

    @Override
    public OrderDetail getOne(int id) {
        rs = commonLib.getOne(table,id);
        OrderDetail OrderDetail = new OrderDetail();
        try {
            if (rs.next()) setValueForOrderDetail(OrderDetail);
        } catch (SQLException ignored) {
        }
        return OrderDetail;
    }

    @Override
    public boolean add(OrderDetail OrderDetail) {
        int flag = 0;
        String UpdateTableSQL = "INSERT INTO OrderDetail"
                + "(order_id, product_id, quantity) VALUE"
                + "(?,?,?)";
        try (Connection con = JDBCConnect.getJDBCConnection()) {
            assert con != null;
            try (PreparedStatement ps = con.prepareStatement(UpdateTableSQL))  {
                new OrderDetailModel().setValueForParam(ps,OrderDetail);
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
    public boolean update(OrderDetail OrderDetail, int id) {
        int flag = 0;
        String UpdateTableSQL = "UPDATE OrderDetail SET order_id = ?, product_id = ?,quantity=?"
                + "where order_detail_id = ?";
        try (Connection con = JDBCConnect.getJDBCConnection()) {
            assert con != null;
            try (PreparedStatement ps = con.prepareStatement(UpdateTableSQL))  {
                new OrderDetailModel().setValueForParam(ps, OrderDetail);
                ps.setInt(4, id);
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
        if (Objects.isNull(new OrderDetailModel().getOne(id))) {
            System.out.println("Not Found Object to Delete");
            return false;
        } else {
            flag = CommonLib.getFlag(table, id);
        }
        JDBCConnect.close(connection,rs,preparedStatement);
        return flag ;
    }
}
