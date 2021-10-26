package Fullstack.service;

import Fullstack.DAO.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Fullstack.Book;

import java.util.List;

//Service-class Autowired to the BookRepository - used for handling the core operations involving Book-data
@Service
public class BookService {

    @Autowired
    private BookDAO bookDAO;

    public Book getBookById(int id) {
        return bookDAO.getBookById(id);
    }

    public Book getBookByName(String name) {
        return bookDAO.getBookByName(name);
    }

    public List<Book> getBooks() {
        return bookDAO.getBooks();
    }

    public Book addBook(Book book) {
        return bookDAO.addBook(book);
    }

    public Book updateBook(Book newBookData, int id) {
        return bookDAO.updateBook(newBookData, id);
    }

    public void deleteBook(int id) {
        bookDAO.deleteBook(id);
    }
}
