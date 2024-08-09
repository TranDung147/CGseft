package Controllers;

import Entity.Product;
import Models.ProductModel;
import Services.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminController", urlPatterns = {"/Admin"})
public class AdminController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        ProductModel productModel = new ProductModel();
        AdminService adminService = new AdminService();
        switch (action) {
            case "list":
                List<Product> products = productModel.getAllProducts();
                request.setAttribute("products", products);
                request.getRequestDispatcher("/views/admin/product/list-product.jsp").forward(request, response);
                break;
            case "edit":
                int id = Integer.parseInt(request.getParameter("id"));
                Product product = productModel.getProductById(id);
                request.setAttribute("product", product);
                request.getRequestDispatcher("/views/admin/product/detail-product.jsp").forward(request, response);
                break;
            case "delete":
                adminService.deleteProduct(request, response);
                break;

            default:

        }

    }

}

