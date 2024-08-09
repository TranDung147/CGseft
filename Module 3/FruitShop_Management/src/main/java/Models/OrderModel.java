package Models;

import Databases.DatabaseConnect;
import Entity.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderModel extends DatabaseConnect {
    public List<Order> getOrderByUserID(int userID) {
        List<Order> orders = new ArrayList<>();
        try {
            Connection con = getConnection();
            String query = "select * from `order` where UserID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                orders.add(new Order(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5), rs.getString(6), rs.getInt(7)));
            }
            con.close();
            ps.close();
            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }

    public void insertOrder(Order o) {
        try {
            Connection con = getConnection();
            String query = "INSERT INTO `order` (UserID, ProductID, Quantity, OrderDate, OrderStatus, TotalCost) values\n" +
                    "\t(?, ?, ?, curdate(), ?, 0)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, o.getUserID()); // Replace with actual user ID
            ps.setInt(2, o.getProductID()); // Replace with actual product ID
            ps.setInt(3, o.getQuantity()); // Replace with actual quantity
            ps.setString(4, o.getOrderStatus()); // Replace with actual order status
            ps.execute();
            con.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Order getOrderByUserIDAndProductID(int userID, int productID) {
        Order order = null;
        try {
            Connection con = getConnection();
            String query = "SELECT * FROM `order` WHERE UserID =? AND ProductID =?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userID);
            ps.setInt(2, productID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                order = new Order(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5), rs.getString(6), rs.getInt(7));
            }
            con.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }

    public static void main(String[] args) {
        List<Order> orders = new OrderModel().getOrderByUserID(2);
        for (Order order : orders) {
            System.out.println(order);
        }

    }

    public void deleteOderByUserIDAndProductID(int userID, int productID) {
        try {
            Connection con = getConnection();
            String query = "DELETE FROM `order` WHERE UserID =? AND ProductID =?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userID);
            ps.setInt(2, productID);
            ps.executeUpdate();
            con.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateOrderQuantityByUserIDAndProductID(int quantity, int userID, int productID) {
        String sql = "update `order` \n" +
                "set Quantity = ? where UserID = ? and ProductID = ? ";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, quantity);
            stmt.setInt(2, userID);
            stmt.setInt(3, productID);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý ngoại lệ tùy theo yêu cầu của ứng dụng
        }
    }

    private double getProductPrice(int productID) {
        String sql = "SELECT Price FROM product WHERE ProductID = ?";
        double price = 0;
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, productID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                price = rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return price; // Trả về 0 nếu không tìm thấy sản phẩm
    }
    public double getTotalCostByUserID(int userID) {
        List<Order> orderList = getOrderByUserID(userID);
        double totalCost = 0;
        for (Order order : orderList) {
            totalCost += order.getQuantity() * getProductPrice(order.getProductID());
        }
        return totalCost;
    }



}
