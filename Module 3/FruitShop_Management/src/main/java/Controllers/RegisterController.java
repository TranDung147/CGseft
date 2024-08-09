package Controllers;
import Entity.User;
import Models.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "RegisterController", urlPatterns = {"/RegisterServlet"})
public class RegisterController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserModel userModel = new UserModel();
        // Lấy các tham số từ request
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User temp = userModel.getByUsername(username);
        if(temp == null) {
            User user = new User(0, username, password, email, "user", " ", "", "");
            userModel.insertUser(user);
            request.setAttribute("errorMessage", "Successful!");
            request.getRequestDispatcher("/views/client/pages/login.jsp").forward(request, response);
        } else {
            // Nếu đăng ký thất bại, chuyển hướng tới trang lỗi hoặc hiển thị thông báo lỗi
            request.setAttribute("errorMessage", "Registration failed. Please try again.");
            request.getRequestDispatcher("/views/client/pages/login.jsp").forward(request, response);
        }
    }
}