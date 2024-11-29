package controllers;

import entity.Book;
import models.BookModel;
import services.BookService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BookController", urlPatterns = {"/books/*"})
public class BookController extends HttpServlet {
    private BookService bookService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.bookService = new BookService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        try {
            if (url == null || url.equals("/")) {
                this.bookService.renderListBook(req, resp);

            }

            switch (url) {
                case "/delete":
                    this.bookService.deleteBook(req, resp);
                    resp.sendRedirect("/books");
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
