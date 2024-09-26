package entity;

import java.sql.Date;

public class Order {
    private int orderId;
    private int tableId;
    private int accountId;
    private Date orderDate;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Order(int orderId, int tableId, int accountId, Date orderDate) {
        this.orderId = orderId;
        this.tableId = tableId;
        this.accountId = accountId;
        this.orderDate = orderDate;
    }

    public Order() {
    }
}
