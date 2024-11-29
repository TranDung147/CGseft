package Controllers;

import Entity.Product;
import Models.ProductModel;
import Services.ShopService;

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
        List<Product> features = new ShopService().paging(request, response);
        request.setAttribute("maxPage", new ShopService().maxPage());
        request.setAttribute("result", features);
        request.setAttribute("curPage", new ShopService().getCurPage(request, response));
        request.getRequestDispatcher("/views/client/pages/product/list.jsp").forward(request, response);
    }
}
