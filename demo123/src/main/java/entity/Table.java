package entity;

public class Table {
    private int tableId;
    private int status;

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public int getTableId() {
        return tableId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Table(int tableId, int status) {
        this.tableId = tableId;
        this.status = status;
    }

    public Table() {
    }


}
