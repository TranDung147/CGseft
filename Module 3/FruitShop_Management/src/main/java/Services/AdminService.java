package Services;

import Entity.Product;
import Models.ProductModel;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdminService {

    public void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("fullName");
        String description = request.getParameter("description");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        float price = Float.parseFloat(request.getParameter("price"));
        int productId = Integer.parseInt(request.getParameter("productID"));


        // Tạo đối tượng Product
        Product product = new Product();
        product.setProductID(productId);
        product.setFullName(fullName);
        product.setDescription(description);
        product.setQuantity(quantity);
        product.setPrice(price);

        // Gọi phương thức update
        ProductModel productModel = new ProductModel();
        productModel.updateProductByProductID(product);
        response.sendRedirect(request.getContextPath() + "/Admin?action=list"); // Chuyển hướng đến trang danh sách sản phẩm

    }

    public void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
            try {
                int productId = Integer.parseInt(request.getParameter("id"));
                ProductModel productModel = new ProductModel();
                productModel.deleteProductByID(productId);
                response.sendRedirect(request.getContextPath() + "/Admin?action=list");
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("fullName");
        String description = request.getParameter("description");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        float price = Float.parseFloat(request.getParameter("price"));

//        // Xử lý file ảnh
//        String imageURL = null;
//
//        ServletContext context = request.getServletContext();
//        // Xử lý tệp hình ảnh được tải lên bằng tiện ích ImageUploadUtil
//        Part imgFilePart = request.getPart("imgFile");
//        String uploadedImageUrl = ImgUpload.uploadImage(imgFilePart, context);
//        if (uploadedImageUrl != null) {
//            imageURL = uploadedImageUrl;
//        } else {
//            // Nếu không có ảnh được tải lên, có thể sử dụng một ảnh mặc định hoặc để trống
//            imageURL = "/views/client/asset/imt/mango.jpg"; // Thay thế bằng URL ảnh mặc định của bạn
//        }
//        System.out.println(imageURL);
        // Tạo đối tượng Product mới
        Product product = new Product();
        product.setFullName(fullName);
        product.setDescription(description);
        product.setQuantity(quantity);
        product.setPrice(price);
//        product.setImageURL(imageURL);

        // Gọi phương thức add
        ProductModel productModel = new ProductModel();
        productModel.addProduct(product);

        response.sendRedirect(request.getContextPath() + "/Admin?action=list");
    }

    public List paging(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
