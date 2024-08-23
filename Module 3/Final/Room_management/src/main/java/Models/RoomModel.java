package Models;

import Databases.DatabaseConnect;
import Entity.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomModel extends DatabaseConnect {

    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        try {
            Connection connection = getConnection();
            String query = "SELECT r.id, r.tenant_name, r.phone_number, r.start_date, r.payment_method_id, p.name, r.notes " +
                    "FROM Room r INNER JOIN PaymentMethod p ON r.payment_method_id = p.id Order by r.id;\n";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                rooms.add (new Room(rs.getInt(1), rs.getNString(2), rs.getNString(3),
                        rs.getDate(4), rs.getInt(5), rs.getNString(6), rs.getNString(7)));

            }
            ps.close();
            rs.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rooms;
    }

    public void addRoom(Room room) {
        try {
            Connection connection = getConnection();
            String query = "INSERT INTO Room (tenant_name, phone_number, start_date, payment_method_id, notes) " +
                    "VALUES (?,?,?,?,?);";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, room.getTenantName());
            ps.setString(2, room.getPhoneNumber());
            ps.setDate(3, room.getStartDate());
            ps.setInt(4, room.getPaymentMethodId());
            ps.setString(5, room.getNotes());
            ps.execute();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteRoomById(int id) {
        try {
            Connection connection = getConnection();
            String query = "DELETE FROM Room WHERE id =?;";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.execute();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        RoomModel roomModel = new RoomModel();
        List<Room> rooms = roomModel.getAllRooms();
        for (Room room : rooms) {
            System.out.println(room);
        }
    }
}
