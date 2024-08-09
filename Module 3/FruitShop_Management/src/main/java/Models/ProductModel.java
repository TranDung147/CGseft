package Models;

import Databases.DatabaseConnect;
import Entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductModel extends DatabaseConnect {

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();

        try {
            Connection connection = getConnection();
            String query = "select * from Product";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                products.add(new Product(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4),
                        rs.getString(5), rs.getFloat(6)));
            }
            ps.close();
            rs.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public Product getProductById(int id) {
        Product product = null;

        try {
            Connection connection = getConnection();
            String query = "select * from Product where ProductID =?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                product = new Product(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4),
                        rs.getString(5), rs.getFloat(6));
            }
            ps.close();
            rs.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    public List<Product> getProductFromOrder(int userID) {
        List<Product> products = new ArrayList<>();

        try {
            Connection connection = getConnection();
            String query = "select p.ProductID, p.FullName, p.Description, o.Quantity, p.ImageURL, p.Price from `order` o inner join Product p\n" +
                    "where o.ProductID = p.ProductID and o.UserID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                products.add(new Product(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4),
                        rs.getString(5), rs.getFloat(6)));
            }
            ps.close();
            rs.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public Map<Integer,Integer> getQuantity() {
        Map<Integer,Integer> map = new HashMap<>();

        try {
            Connection connection = getConnection();
            String query = "SELECT ProductID, Quantity FROM product";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                map.put(rs.getInt(1), rs.getInt(2));
            }
            ps.close();
            rs.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return map;
    }
    public void updateProductByProductID(Product product) {
        try {
            Connection connection = getConnection();
            String query = "UPDATE Product SET FullName=?, Description=?, Quantity=?, Price=? WHERE ProductID=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, product.getFullName());
            ps.setString(2, product.getDescription());
            ps.setInt(3, product.getQuantity());
            ps.setFloat(4, product.getPrice());
            ps.setInt(5, product.getProductID());
            ps.execute();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteProductByID(int productID) {
        String query = "DELETE FROM Product WHERE ProductID = ?";

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, productID);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addProduct(Product product) {
        String query = "INSERT INTO Product (FullName, Description, Quantity, ImageURL, Price) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, product.getFullName());
            ps.setString(2, product.getDescription());
            ps.setInt(3, product.getQuantity());
            ps.setString(4, product.getImageURL());
            ps.setFloat(5, product.getPrice());
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ProductModel productModel = new ProductModel();
        // Cập nhật thông tin sản phẩm với ID cụ thể
        Product productToUpdate = new Product(1, "Name", "Updated Description", 10, "new-image-url.jpg", 99.99f);
        productModel.updateProductByProductID(productToUpdate);
        System.out.println("Product updated successfully.");

        // In ra sản phẩm sau khi cập nhật để kiểm tra
        Product updatedProduct = productModel.getProductById(1);
        System.out.println("Updated Product with ID 1: " + updatedProduct);
        }
}
