package dao;


import entity.Equipment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EquipmentDAO extends JDBCConnect {
    public static List<Equipment> search(String searchValue) {
        List<Equipment> dataList = new ArrayList<>();

        getJDBCConnection();

        try {
            String sql = "SELECT * FROM db_equipment WHERE concat(equipment_id, equipment_name,status,maintain_date) LIKE ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + searchValue + "%");

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Equipment equip = new Equipment(
                        rs.getInt("equipment_id"),
                        rs.getString("equipmain_name"),
                        rs.getInt("status"),
                        rs.getString("maintain_date")
                );
                dataList.add(equip);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EquipmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        close();
        return dataList;
    }

    public static List<Equipment> sortByName() {
        List<Equipment> dataList = new ArrayList<>();

        getJDBCConnection();
        try {
            //B2. Query du lieu ra
            String sql = "select * from db_equipment order by equipment_name asc";
            statement = conn.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Equipment equip = new Equipment(
                        rs.getInt("equipment_id"),
                        rs.getString("equipmain_name"),
                        rs.getInt("status"),
                        rs.getString("maintain_date")
                );
                dataList.add(equip);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EquipmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        close();

        return dataList;
    }

    public static List<Equipment> select() {
        List<Equipment> dataList = new ArrayList<>();

        getJDBCConnection();
        try {

            String sql = "select * from db_account";
            statement = conn.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Equipment equip = new Equipment(
                        rs.getInt("equipment_id"),
                        rs.getString("equipmain_name"),
                        rs.getInt("status"),
                        rs.getString("maintain_date")
                );
                dataList.add(equip);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EquipmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        close();

        return dataList;
    }

    public static void insert(Equipment equip) {
        getJDBCConnection();
        try {

            String sql = "insert into db_equipment (equipment_id,equipment_name, status, maintain_date) values (?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, equip.getEquipment_id());
            statement.setString(2, equip.getEquipment_name());
            statement.setInt(3, equip.getStatus());
            statement.setString(4, equip.getMaintain_date());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(EquipmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }

    public static void update(Equipment equip) {
        getJDBCConnection();
        try {
            String sql = "update equip set equipment_id = ?, equipment_name = ?, status = ?, maintain_date =?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, equip.getEquipment_id());
            statement.setString(2, equip.getEquipment_name());
            statement.setInt(3, equip.getStatus());
            statement.setString(4, equip.getMaintain_date());
            statement.execute();

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(EquipmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }

    public static void delete(int equipment_id) {
        getJDBCConnection();
        try {

            String sql = "delete from db_equipment where id = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, equipment_id);

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(EquipmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }


    public static Equipment findById(int equipment_id) {
        Equipment equip = null;
        getJDBCConnection();
        try {

            String sql = "select * from db_equipment where equipment_id = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, equipment_id);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                        equip = new Equipment(
                        rs.getInt("equipment_id"),
                        rs.getString("equipment_name"),
                        rs.getInt("status"),
                        rs.getString("maintain_date")
                );

                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EquipmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        close();

        return equip;
    }


    public boolean isIDExits(int equipment_id) {
        getJDBCConnection();
        try {
            String sql = "select * from db_equipment where equipment_id = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, equipment_id);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EquipmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return false;
    }
}
