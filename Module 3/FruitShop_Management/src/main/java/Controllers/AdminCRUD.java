package Controllers;

import Services.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminCRUD", urlPatterns = {"/AdminCRUD"})
public class AdminCRUD extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminService adminService = new AdminService();
        String action = request.getParameter("action");
        switch (action) {
            case "add":
                adminService.addProduct(request, response);
                break;
            case "update":
                System.out.println(1);
                adminService.updateProduct(request, response);
                break;
            default:
                throw new ServletException("Invalid action");
        }
    }
}
