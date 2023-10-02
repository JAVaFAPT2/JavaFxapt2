package model;

import common.ICommon;
import dao.JDBCConnect;
import entity.Equipment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

import common.CommonLib;


public class EquipmentModel implements ICommon<Equipment> {
    private static final String table ="equipment";
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;
    private CommonLib commonLib ;

    public void setValueForEquipment(Equipment Equipment) throws SQLException {
        Equipment.setEquipmentId(rs.getInt("id"));
        Equipment.setEquipmentName(rs.getString("name"));
        Equipment.setStatus(rs.getInt("status"));
        Equipment.setMaintainDate(rs.getDate("maintainDate"));
    }

    public void setValueForParam(PreparedStatement ps, Equipment Equipment) throws SQLException {
        ps.setInt(1, Equipment.getEquipmentId());
        ps.setString(2, Equipment.getEquipmentName());
        ps.setInt(3, Equipment.getStatus());
        ps.setDate(3, Equipment.getMaintainDate());
    }
    @Override
    public ArrayList<Equipment> getAll() {
        ArrayList<Equipment> arrayList = new ArrayList<>();
        rs= commonLib.getAll(table);
        try{
            while (rs.next()) {
                Equipment Equipment = new Equipment();
                arrayList.add(Equipment);
            }
        }catch (SQLException ignored){}
        return arrayList;
    }

    @Override
    public Equipment getOne(int id) {
        rs = commonLib.getOne(table,id);
        Equipment Equipment = new Equipment();
        try {
            if (rs.next()) setValueForEquipment(Equipment);
        } catch (SQLException ignored) {
        }
        return Equipment;
    }

    @Override
    public boolean add(Equipment Equipment) {
        int flag = 0;
        String UpdateTableSQL = "INSERT INTO Equipment"
                + "(equipment_name, status, maintain_date) VALUE"
                + "(?,?,?)";
        try (Connection con = JDBCConnect.getJDBCConnection()) {
            assert con != null;
            try (PreparedStatement ps = con.prepareStatement(UpdateTableSQL))  {
                ps.setString(1, Equipment.getEquipmentName());
                ps.setInt(2, Equipment.getStatus());
                ps.setDate(3, Equipment.getMaintainDate());
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
    public boolean update(Equipment Equipment, int id) {
        int flag = 0;
        String UpdateTableSQL = "UPDATE Equipment SET equipment_name = ?, status = ?, maintain_date = ?,"
                + "where id = ?";
        try (Connection con = JDBCConnect.getJDBCConnection()) {
            assert con != null;
            try (PreparedStatement ps = con.prepareStatement(UpdateTableSQL))  {
                new EquipmentModel().
                        setValueForParam(ps, Equipment);
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
        if (Objects.isNull(new EquipmentModel().getOne(id))) {
            System.out.println("Not Found Object to Delete");
            return false;
        } else {
            flag = CommonLib.getFlag(table, id);
        }
        JDBCConnect.close(connection,rs,preparedStatement);
        return flag ;
    }


}
