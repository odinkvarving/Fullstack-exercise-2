package Fullstack.service;

import Fullstack.DAO.AuthorBookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Fullstack.Author;
import Fullstack.Book;
import Fullstack.repo.BookRepository;
import java.util.List;

//Service-class that is Autowired to the AuthorRepository and BookRepository - used for handling core operations involving both Author and Book-data
@Service
public class AuthorBooksService {

    @Autowired
    private AuthorBookDAO authorBookDAO;

    @Autowired
    private BookRepository bookRepository;

    public int updateAuthorBook(int authorId, Book newBook) {
        return authorBookDAO.updateAuthorBook(authorId, newBook);
    }

    public List<Book> findBooksByAuthor(int authorId) {
        return authorBookDAO.findBooksByAuthor(authorId);
    }

    public Book removeBookByAuthor(int authorId, int bookId) {
        return authorBookDAO.removeBookByAuthor(authorId, bookId);
    }
}
