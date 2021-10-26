package Fullstack.DAO;

import Fullstack.Author;
import Fullstack.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorBookDAO {

    @Autowired
    AddressDAO addressDAO;

    @Autowired
    AuthorDAO authorDAO;

    @Autowired
    BookDAO bookDAO;

    private JdbcTemplate jdbcTemplate;
    private static final Logger log = LoggerFactory.getLogger(AuthorBookDAO.class);

    RowMapper<Book> bookRowMapper = (rs, rowNum) -> {
        Book book = new Book();
        book.setId(rs.getInt("id"));
        book.setName(rs.getString("name"));
        book.setPublisher(rs.getString("publisher"));
        return book;
    };

    public AuthorBookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int updateAuthorBook(int id, Book book) {

        if(id != 0 && book != null) {
            bookDAO.addBook(book);

            String sql = "select distinct * from books WHERE id in (select MAX(id) FROM books)";
            Book addedBook = jdbcTemplate.queryForObject(sql, bookRowMapper);
            int bookId = addedBook.getId();

            String insertBook = "INSERT INTO authorbooks VALUES (?,?)";
            int insert = jdbcTemplate.update(insertBook, id, bookId);
            if(insert == 1) {
                log.info(book.getName() + " added to author: " + authorDAO.getAuthorById(id));
                return 1;
            }
        }
        log.info("There is no author with this ID. ");
        return 0;
    }

    public List<Book> findBooksByAuthor(int id) {
        Author author = authorDAO.getAuthorById(id);
        List<Book> bookList;

        String findBook = "SELECT books.id, books.name, books.publisher FROM books JOIN authorbooks ON authorbooks.bookId = books.id WHERE authorbooks.authorId = ?";

        if(author != null) {
            try {
                return bookList = jdbcTemplate.query(findBook, bookRowMapper, id);
            }catch (DataAccessException e) {
                log.info("Book not found. ");
            }
        }
        return null;
    }

    public Book removeBookByAuthor(int authorId, int bookId) {
        String sql = "DELETE FROM authorbooks WHERE authorId = ? AND bookId = ?";
        int insert = jdbcTemplate.update(sql, authorId, bookId);
        if(insert == 1) {
            log.info(bookDAO.getBookById(bookId).getName()  + " removed from " + authorDAO.getAuthorById(authorId).getName());
            return bookDAO.getBookById(bookId);
        }
        return null;
    }
}
