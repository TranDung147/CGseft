package Services;

import Entity.Product;
import Models.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShopService {
    public List paging(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyWord = request.getParameter("keyword");
        
        int currentPage = getCurPage(request, response);
        List<Product> products = new ArrayList();

        List<Product> allProducts = new ProductModel().getAllProducts();
        int max = (currentPage*12-1 > (allProducts.size()-1))?allProducts.size()-1:currentPage*12-1;
        for (int i = currentPage*12 - 12; i <= max; i++) {
            products.add(allProducts.get(i));
        }
        return products;
    }

    public int maxPage() {
        List<Product> products = new ProductModel().getAllProducts();
        if (products.size() % 12 == 0) return products.size()/12;
        else return products.size()/12 + 1;
    }

    public int getCurPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int currentPage = 1;
        try {
            currentPage = Integer.parseInt(request.getParameter("page"));
        } catch (NumberFormatException e) {

        }
        return currentPage;
    }
}
