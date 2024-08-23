package Controllers;

import Entity.Room;
import Models.RoomModel;
import Services.RoomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@WebServlet(name = "RoomController", urlPatterns = {"/Room"})
public class RoomController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Room> rooms;
        rooms = new RoomModel().getAllRooms();
        request.setAttribute("rooms", rooms);
        request.getRequestDispatcher("room_list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        RoomService service = new RoomService();
        switch (action) {
            case "add":
                try {
                    service.addRoom(request, response);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "delete":
                try {
                    service.deleteRoom(request, response);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }
}