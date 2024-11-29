package Controllers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import Entity.User;
import Models.UserModel;

@WebServlet(name = "LoginController", urlPatterns = {"/Login"})
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");

        String password = req.getParameter("password");

        String alertMsg = "";

        if (username == null || password == null) {
            alertMsg = "Username and password can't be empty!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/client/pages/login.jsp").forward(req, resp);
            return;
        }

        UserModel userModel = new UserModel();

        User user = userModel.getByUsername(username);

        if (user != null && password.equals(user.getPassword())) {
            HttpSession session = req.getSession(true);
            session.setAttribute("account", user);
            if ("admin".equals(user.getRole())) {
                resp.sendRedirect(req.getContextPath()+"/Admin?action=list");
            } else {
                resp.sendRedirect(req.getContextPath() + "/Shop");
            }
        } else {
            alertMsg = "Username or password isn't correct";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/client/pages/login.jsp").forward(req, resp);
        }
    }
}
