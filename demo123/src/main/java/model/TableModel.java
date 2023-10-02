package model;

import common.CommonLib;
import common.ICommon;
import dao.JDBCConnect;
import entity.Table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class TableModel implements ICommon<Table> {
    private CommonLib commonLib;
    private static final String table="tbltable";
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;

    public void setValueForTable(Table Table) throws SQLException {
        Table.setTableId(rs.getInt("table_id"));
        Table.setStatus(rs.getInt("status"));
    }

    public void setValueForParam(PreparedStatement ps, Table Table) throws SQLException {
        ps.setInt(1,Table.getStatus());
    }

    @Override
    public ArrayList<Table> getAll() {
        ArrayList<Table> arrayList = new ArrayList<>();
        rs= commonLib.getAll(table);
        try{
            while (rs.next()) {
                Table Table = new Table();
                arrayList.add(Table);
            }
        }catch (SQLException ignored){}
        return arrayList;
    }

    @Override
    public Table getOne(int id) {
        rs = commonLib.getOne(table,id);
        Table Table = new Table();
        try {
            if (rs.next()) setValueForTable(Table);
        } catch (SQLException ignored) {
        }
        return Table;
    }

    @Override
    public boolean add(Table Table) {
        int flag = 0;
        String UpdateTableSQL = "INSERT INTO " + table
                + "(status) VALUE"
                + "(?)";
        try (Connection con = JDBCConnect.getJDBCConnection()) {
            assert con != null;
            try (PreparedStatement ps = con.prepareStatement(UpdateTableSQL))  {
                new TableModel().setValueForParam(ps, Table);
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
    public boolean update(Table Table, int id) {
        int flag = 0;
        String UpdateTableSQL = "UPDATE "+table+" SET status = ?"
                + "where table_id = ?";
        try (Connection con = JDBCConnect.getJDBCConnection()) {
            assert con != null;
            try (PreparedStatement ps = con.prepareStatement(UpdateTableSQL))  {
                new TableModel().setValueForParam(ps, Table);
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
        if (Objects.isNull(new TableModel().getOne(id))) {
            System.out.println("Not Found Object to Delete");
            return false;
        } else {
            flag = CommonLib.getFlag(table, id);
        }
        JDBCConnect.close(connection,rs,preparedStatement);
        return flag ;
    }

}
