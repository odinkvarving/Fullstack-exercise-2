package Fullstack.DAO;

import Fullstack.Author;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class AuthorDAO {

    @Autowired
    private AddressDAO addressDAO;

    private JdbcTemplate jdbcTemplate;
    private static final Logger log = LoggerFactory.getLogger(BookDAO.class);

    RowMapper<Author> rowMapper = (rs, rowNum) -> {
        Author author = new Author();
        author.setId(rs.getInt("id"));
        author.setName(rs.getString("name"));
        author.setEmail(rs.getString("email"));
        author.setAddress(addressDAO.getAddressById(rs.getInt("address")));
        return author;
    };

    public AuthorDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Author getAuthorByName(String name) {
        String sql = "SELECT id, name, email, address FROM authors WHERE name = ?";
        Author author = null;
        try {
            author = (Author)jdbcTemplate.queryForObject(sql, new Object[]{name}, rowMapper);
        }catch (DataAccessException e) {
            log.info("Author not found: " + name);
        }
        return author;
    }

    public Author getAuthorById(int id) {
        String sql = "SELECT id, name, email, address FROM authors where id = ?";
        Author author = null;
        try {
            author = (Author) jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        }catch (DataAccessException e) {
            log.info("Author not found: " + id);
        }
        return author;
    }

    public List<Author> getAuthors() {
        String sql = "SELECT id, name, email, address FROM authors";
        return jdbcTemplate.query(sql, rowMapper);
    }

    public Author addAuthor(Author author) {
        if(author.getId() == 0 || author.getName().equals("") || author.getEmail().equals("") || author.getAddress() == null) {
            throw new IllegalArgumentException("Some of the values entered are empty. ");
        }
        String sql = "INSERT INTO authors(name, email, address) VALUES (?,?,?)";
        int insert = jdbcTemplate.update(sql, author.getName(), author.getEmail(), author.getAddress());
        if(insert == 1) {
            log.info("New author added: " + author.getName());
        }else {
            log.error("Could not add author: " + author.getName());
        }
        return author;
    }

    public int updateAuthor(Author author, int id) {
        String sql = "UPDATE authors SET id = ?, name = ?, email = ?, address = ? WHERE id = ?";
        int update = jdbcTemplate.update(sql, author.getId(), author.getName(), author.getEmail(), author.getAddress(), id);
        if(update == 1) {
            log.info("Author updated: " + id);
            return 1;
        }
        return 0;
    }

    public int deleteAuthor(int id) {
        String sql = "DELETE FROM authors WHERE id = ?";
        int insert = jdbcTemplate.update(sql, id);
        if(insert == 1) {
            log.info(getAuthorById(id).getName() + " was deleted. ");
            return 1;
        }else {
            return 0;
        }
    }
}
