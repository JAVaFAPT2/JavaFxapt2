package entity;

public class Equipment {
    private int equipment_id;
    private String equipment_name;
    private int status;
    private String maintain_date;


    public Equipment(int equipment_id, String equipment_name, int status, String maintain_date) {
        this.equipment_id = equipment_id;
        this.equipment_name = equipment_name;
        this.status = status;
        this.maintain_date = maintain_date;
    }

    public Equipment() {
    }

    public int getEquipment_id() {
        return equipment_id;
    }

    public void setEquipment_id(int equipment_id) {
        this.equipment_id = equipment_id;
    }

    public String getEquipment_name() {
        return equipment_name;
    }

    public void setEquipment_name(String equipment_name) {
        this.equipment_name = equipment_name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMaintain_date() {
        return maintain_date;
    }

    public void setMaintain_date(String maintain_date) {
        this.maintain_date = maintain_date;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "equipment_id=" + equipment_id +
                ", equipment_name='" + equipment_name + '\'' +
                ", status=" + status +
                ", maintain_date='" + maintain_date + '\'' +
                '}';
    }
}
