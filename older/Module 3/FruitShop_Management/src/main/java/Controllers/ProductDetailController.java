package Controllers;
import Entity.Product;
import Models.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "ProductDetailController", urlPatterns = {"/ProductDetail"})
public class ProductDetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = new ProductModel().getProductById(id);
        Map<Integer,Integer> mapQuantity = new ProductModel().getQuantity();
        request.setAttribute("mapQuantity", mapQuantity);
        request.setAttribute("product", product);
        request.getRequestDispatcher("/views/client/pages/product/product-detail.jsp").forward(request, response);
    }
}
