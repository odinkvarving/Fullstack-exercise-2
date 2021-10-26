package Fullstack.DAO;

import Fullstack.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDAO {

    private JdbcTemplate jdbcTemplate;
    private static final Logger log = LoggerFactory.getLogger(BookDAO.class);

    RowMapper<Book> rowMapper = (rs, rowNum) -> {
        Book book = new Book();
        book.setId(rs.getInt("id"));
        book.setName(rs.getString("name"));
        book.setPublisher(rs.getString("publisher"));
        return book;
    };

    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Book getBookByName(String name) {
        String sql = "SELECT id, name, publisher FROM books WHERE name = ?";
        Book book = null;
        try {
            book = (Book)jdbcTemplate.queryForObject(sql, new Object[]{name}, rowMapper);
        }catch (DataAccessException e) {
            log.info("Book not found " + name);
        }
        return book;
    }

    public Book getBookById(int id) {
        String sql = "SELECT id, name, publisher FROM books WHERE id = ?";
        Book book = null;
        try {
            book = (Book)jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        }catch (DataAccessException e) {
            log.info("Book not found" + id);
        }
        return book;
    }

    public List<Book> getBooks() {
        String sql = "SELECT id, name, publisher FROM books";
        return jdbcTemplate.query(sql, rowMapper);
    }

    public Book addBook(Book book) {
        String sql = "INSERT INTO books(name, publisher) VALUES(?,?)";
        int insert = jdbcTemplate.update(sql, book.getName(), book.getPublisher());
        if(insert == 1) {
            log.info("New book added: " + book.getName());
        }
        return book;
    }

    public Book updateBook(Book book, int id) {
        String sql = "UPDATE books SET id = ?, name = ?, publisher = ? WHERE id = ?";
        int update = jdbcTemplate.update(sql, book.getId(), book.getName(), book.getPublisher(), id);
        if(update == 1) {
            log.info("Book updated: " + id);
        }
        return book;
    }

    public void deleteBook(int id) {
        jdbcTemplate.update("DELETE FROM books WHERE id = ?", id);
    }
}
