package models;

import databases.DatabaseConnect;
import entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BookModel {
    public Connection conn;

    public BookModel() {
        this.conn = DatabaseConnect.getConnection();
    }

    public ResultSet getBooks() throws SQLException {
        //Chuan bi cau lenh truy van
        String sql = "SELECT * FROM books";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        //Thuc thi cau lenh truy van
        return ps.executeQuery();
    }

    public void destroyBook(int id) {
        String sql = "DELETE FROM books WHERE id = ?";
        try (PreparedStatement ps = this.conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
