package Services;

import Entity.Room;
import Models.RoomModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class RoomService {
    public void addRoom(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {
        String tenantName = request.getParameter("tenantName");
        String phoneNumber = request.getParameter("phoneNumber");
        java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("startDate"));
        Date startDate = new Date(utilDate.getTime());
        int paymentMethodId = Integer.parseInt(request.getParameter("paymentMethodId"));
        String notes = request.getParameter("notes");

        Room room = new Room(0, tenantName, phoneNumber, startDate, paymentMethodId,"", notes);
        new RoomModel().addRoom(room);
        response.sendRedirect(request.getContextPath() + "/Room");
    }

    public void deleteRoom(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {
        int roomId = Integer.parseInt(request.getParameter("id"));
        new RoomModel().deleteRoomById(roomId);
        response.sendRedirect(request.getContextPath() + "/Room");
    }
}
