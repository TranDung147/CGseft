package Controllers;

import Entity.Order;
import Entity.Product;
import Entity.User;
import Models.OrderModel;
import Models.ProductModel;
import Services.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@WebServlet(name = "OrderController", urlPatterns = {"/Order"})
public class OrderController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Display all orders
        OrderModel orderModel = new OrderModel();
        HttpSession session = request.getSession(false);
        User u = (User)session.getAttribute("account");
        Map<Integer,Integer> mapQuantity = new ProductModel().getQuantity();
        List<Product> products = new ProductModel().getProductFromOrder(u.getUserID());
        request.setAttribute("totalCost", new OrderModel().getTotalCostByUserID(u.getUserID()));
        request.setAttribute("products", products);
        request.setAttribute("mapQuantity", mapQuantity);
        request.getRequestDispatcher("/views/client/pages/order.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderService orderService = new OrderService();
        String action = request.getParameter("action");
        switch (action) {
            case "add":
                orderService.createNewOrder(request, response);
                break;
            case "delete":
                orderService.deleteOrderById(request, response);
                break;
            case "update":
                orderService.updateOrderById(request, response);
                break;

            default:
                // Redirect to a default action or error page
                response.sendRedirect("error.jsp");
                break;
        }
    }
}
