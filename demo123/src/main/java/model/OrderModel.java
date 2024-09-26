package model;

import common.CommonLib;
import common.ICommon;
import dao.JDBCConnect;
import entity.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class OrderModel implements ICommon<Order> {
    private CommonLib commonLib;
    private static final String table="order";
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;

    public void setValueForOrder(Order Order) throws SQLException {
        Order.setOrderId(rs.getInt("order_id"));
        Order.setTableId(rs.getInt("table_id"));
        Order.setAccountId(rs.getInt("account_id"));
        Order.setOrderDate(rs.getDate("order_date"));
    }

    public void setValueForParam(PreparedStatement ps, Order Order) throws SQLException {
        ps.setInt(1, Order.getOrderId());
        ps.setInt(2, Order.getTableId());
        ps.setInt(3, Order.getAccountId());
        ps.setDate(4, Order.getOrderDate());
    }
    @Override
    public ArrayList<Order> getAll() {
        ArrayList<Order> arrayList = new ArrayList<>();
        rs= commonLib.getAll(table);
        try{
            while (rs.next()) {
                Order Order = new Order();
                arrayList.add(Order);
            }
        }catch (SQLException ignored){}
        return arrayList;
    }

    @Override
    public Order getOne(int id) {
        rs = commonLib.getOne(table,id);
        Order Order = new Order();
        try {
            if (rs.next()) setValueForOrder(Order);
        } catch (SQLException ignored) {
        }
        return Order;
    }

    @Override
    public boolean add(Order Order) {
        int flag = 0;
        String UpdateTableSQL = "INSERT INTO Order"
                + "( table_id, account_id, order_date) VALUE"
                + "(?,?,?)";
        try (Connection con = JDBCConnect.getJDBCConnection()) {
            assert con != null;
            try (PreparedStatement ps = con.prepareStatement(UpdateTableSQL))  {
                ps.setInt(1, Order.getTableId());
                ps.setInt(2, Order.getAccountId());
                ps.setDate(3, Order.getOrderDate());
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
    public boolean update(Order Order, int id) {
        int flag = 0;
        String UpdateTableSQL = "UPDATE Order SET table_id = ?, account_id = ?, order_date = ?,"
                + "where order_id = ?";
        try (Connection con = JDBCConnect.getJDBCConnection()) {
            assert con != null;
            try (PreparedStatement ps = con.prepareStatement(UpdateTableSQL))  {
                new OrderModel().
                        setValueForParam(ps, Order);
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
        if (Objects.isNull(new OrderModel().getOne(id))) {
            System.out.println("Not Found Object to Delete");
            return false;
        } else {
            flag = CommonLib.getFlag(table, id);
        }
        JDBCConnect.close(connection,rs,preparedStatement);
        return flag ;
    }
}
