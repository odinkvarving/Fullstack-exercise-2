package Fullstack.service;

import Fullstack.DAO.AuthorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Fullstack.Author;
import Fullstack.DTO.AuthorDTO;

import java.util.List;

//Service-class Autowired to the AuthorRepository - used for handling the core operations involving Author-data
@Service
public class AuthorService {

    @Autowired
    private AuthorDAO authorDAO;

    public Author getAuthorByName(String name) {
        return authorDAO.getAuthorByName(name);
    }

    public Author getAuthorById(int id) {
        return authorDAO.getAuthorById(id);
    }

    public List<Author> getAuthors() {
        return authorDAO.getAuthors();
    }

    public Author addAuthor(Author author) {
        return authorDAO.addAuthor(author);
    }

    public int updateAuthor(Author newAuthorData, int id) {
        return authorDAO.updateAuthor(newAuthorData, id);
    }

    public int deleteAuthor(int id) {
       return authorDAO.deleteAuthor(id);
    }

    //Function for converting Author to AuthorDTO
    public AuthorDTO authorToAuthorDTO(Author author) {
        return new AuthorDTO(author);
    }
}
