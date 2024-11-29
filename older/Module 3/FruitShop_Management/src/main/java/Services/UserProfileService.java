package Services;

import Entity.User;
import Models.UserModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserProfileService {
    public void updateUserProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("account");
        String fName = request.getParameter("firstName");
        String lName = request.getParameter("lastName");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        user.setFname(fName);
        user.setLname(lName);
        user.setPassword(password);
        user.setAddress(address);
        new UserModel().updateUser(user);
        response.sendRedirect(request.getContextPath() + "/UserProfile");
    }
}
