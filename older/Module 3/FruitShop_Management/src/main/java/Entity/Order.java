package Entity;


import java.sql.Date;

public class Order {
    private int orderID;
    private int userID;
    private int productID;
    private int quantity;
    private Date orderDate;
    private String orderStatus;
    private double totalCost;


    public Order() {
    }

    public Order(int orderID, int userID, int productID, int quantity, Date orderDate, String orderStatus, double totalCost) {
        this.orderID = orderID;
        this.userID = userID;
        this.productID = productID;
        this.quantity = quantity;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.totalCost = totalCost;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", userID=" + userID +
                ", productID=" + productID +
                ", quantity=" + quantity +
                ", orderDate=" + orderDate +
                ", orderStatus='" + orderStatus + '\'' +
                ", totalCost=" + totalCost +
                '}';
    }
}
