package Services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Entity.Order;
import Entity.User;
import Models.OrderModel;
import java.io.IOException;


public class OrderService {
    public void createNewOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        User user = (User)session.getAttribute("account");
        Order order = new Order();
        order.setUserID(user.getUserID());
        order.setProductID(Integer.parseInt(request.getParameter("productId")));
        order.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        order.setOrderStatus("Pending");
        Order temp = new OrderModel().getOrderByUserIDAndProductID(order.getUserID(), order.getProductID());
        if(temp == null) {
            new OrderModel().insertOrder(order);
        } else {
            addQuantity(request, response, temp.getQuantity() + order.getQuantity());
        }
        response.sendRedirect(request.getContextPath() + "/Shop");
    }

    public void deleteOrderById(HttpServletRequest request, HttpServletResponse response) throws IOException{
        User user = (User)request.getSession(false).getAttribute("account");
        int productId = Integer.parseInt(request.getParameter("productId"));
        new OrderModel().deleteOderByUserIDAndProductID(user.getUserID(), productId);
        response.sendRedirect(request.getContextPath() + "/Order");
    }

    public void addQuantity(HttpServletRequest request, HttpServletResponse response, int quantity) throws IOException {
        HttpSession session = request.getSession(false);
        User user = (User)session.getAttribute("account");
        int productId = Integer.parseInt(request.getParameter("productId"));
        new OrderModel().updateOrderQuantityByUserIDAndProductID(quantity, user.getUserID(), productId);
    }

    public void updateOrderById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        User user = (User)session.getAttribute("account");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int productId = Integer.parseInt(request.getParameter("productId"));
        new OrderModel().updateOrderQuantityByUserIDAndProductID(quantity, user.getUserID(), productId);
        response.sendRedirect(request.getContextPath() + "/Order");
    }
}
