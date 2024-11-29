package controller;

import model.Customer;
import service.CustomerService;
import service.CustomerServiceImpl;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    private final CustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lấy Parameters (Dữ liệu request gửi đi) có name là "action".
        String action = req.getParameter("action");

        // Nếu dữ liệu request gửi đi không có "action" thì sẽ trả về null

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(req, resp);
                break;
            case "edit":
                updateCustomer(req, resp);
                break;
            case "delete":
                deleteCustomer(req, resp);
                break;
            default:
                break;
        }
    }

    // Phương thức xóa customer dựa theo id.
    private void deleteCustomer(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Customer customer = this.customerService.findById(id);
        RequestDispatcher dispatcher;
        if (customer == null) {
            dispatcher = req.getRequestDispatcher("error-404.jsp");
        } else {
            this.customerService.remove(id);
            try {
                resp.sendRedirect("/customers");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateCustomer(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        Customer customer = this.customerService.findById(id);
        RequestDispatcher dispatcher;
        if (customer == null) {
            dispatcher = req.getRequestDispatcher("error-404.jsp");
        } else {
            customer.setName(name);
            customer.setEmail(email);
            customer.setAddress(address);
            this.customerService.update(id, customer);
            req.setAttribute("customer", customer);
            req.setAttribute("message", "Customer information was updated");
            dispatcher = req.getRequestDispatcher("customer/edit.jsp");
            try {
                dispatcher.forward(req, resp);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }
    }

    private void createCustomer(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        int id = (int) (Math.random() * 10000);

        Customer customer = new Customer(id, name, email, address);
        this.customerService.saveCustomer(customer);
        RequestDispatcher dispatcher = req.getRequestDispatcher("customer/create.jsp");
        req.setAttribute("message", "Customer information was created");

        try {
            dispatcher.forward(req, resp);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "view":
                viewCustomer(request, response);
                break;
            default:
                listCustomers(request, response);
                break;
        }
    }
}