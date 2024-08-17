package Models;

import Databases.DatabaseConnect;
import Entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserModel extends DatabaseConnect {

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            Connection connection = getConnection();
            String query = "select * from User";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                users.add(new User(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getString(8)));
            }
            rs.close();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public void updateUser(User user) {
        try {
            Connection connection = getConnection();
            String query = "Update User set Fname = ?, LName = ?, Pass = ?, Address = ? where userID = ?;";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, user.getFname());
            ps.setString(2, user.getLname());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getAddress());
            ps.setInt(5, user.getUserID());
            ps.executeUpdate();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        public User getByUsername (String username){
            User user = null;
            try {
                Connection connection = getConnection();
                String query = "select * from User where username =?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, username);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    user = new User(rs.getInt(1), rs.getString(2),
                            rs.getString(3), rs.getString(4),
                            rs.getString(5), rs.getString(6),
                            rs.getString(7), rs.getString(8));
                }
                rs.close();
                ps.close();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return user;
        }

        public void insertUser (User user){
            try {
                Connection connection = getConnection();
                String query = "INSERT INTO User (UserName, Pass, Email, Role, FName, LName, Address)\n" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?);";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getEmail());
                ps.setString(4, user.getRole());
                ps.setString(5, user.getFname());
                ps.setString(6, user.getLname());
                ps.setString(7, user.getAddress());
                ps.execute();
                ps.close();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
