package services;

import entity.Book;
import models.BookModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookService {

    public BookModel bookModel;

    public BookService() {
        this.bookModel = new BookModel();
    }

    public void renderListBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        //get data from model
        List<Book> books = this.getAllBooks();

        request.setAttribute("books", books);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/list.jsp");
        dispatcher.forward(request, response);
    }

    public List<Book> getAllBooks() throws SQLException {
        List<Book> books = new ArrayList<>();
        ResultSet rs = this.bookModel.getBooks();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String description = rs.getString("description");
            int price = rs.getInt("price");
            int category = rs.getInt("category_id");
            Book book = new Book(name, description, price, category);
            book.setId(id);
            books.add(book);
        }
        return books;
    }

    public void deleteBook(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        this.bookModel.destroyBook(id);
    }
}
