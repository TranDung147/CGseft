package Controllers;

import Entity.User;
import Services.UserProfileService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserProfile", urlPatterns = {"/UserProfile"})
public class UserProfile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("user", (User)request.getSession(false).getAttribute("account"));
        request.getRequestDispatcher(request.getContextPath() + "/views/client/pages/profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "update":
                new UserProfileService().updateUserProfile(request, response);
                break;
        }
    }
}
