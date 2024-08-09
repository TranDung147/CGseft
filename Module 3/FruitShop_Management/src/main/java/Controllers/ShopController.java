package Controllers;

import Entity.Product;
import Models.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@WebServlet(name = "ShopController", urlPatterns = {"/Shop"})
public class ShopController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductModel productModel = new ProductModel();
        List<Product> features = productModel.getAllProducts();
        request.setAttribute("result", features);
        request.getRequestDispatcher("/views/client/pages/product/list.jsp").forward(request, response);
    }
}
