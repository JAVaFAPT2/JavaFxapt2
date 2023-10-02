package entity;

import java.sql.Date;

public class Equipment {
    private int equipmentId;
    private String equipmentName;
    private int status;
    private Date maintainDate;

    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getMaintainDate() {
        return maintainDate;
    }

    public void setMaintainDate(Date maintainDate) {
        this.maintainDate = maintainDate;
    }

    public Equipment(int equipmentId, String equipmentName, int status, Date maintainDate) {
        this.equipmentId = equipmentId;
        this.equipmentName = equipmentName;
        this.status = status;
        this.maintainDate = maintainDate;
    }

    public Equipment() {
    }
}
