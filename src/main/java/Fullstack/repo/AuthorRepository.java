package Fullstack.repo;

import org.springframework.stereotype.Repository;
import Fullstack.Address;
import Fullstack.Author;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Repository-class with methods supporting creating, reading, updating and deleting of back-end-data
@Repository
public class AuthorRepository {
    private List<Author> authors;

    public AuthorRepository() {
        //Dummy-objects
        this.authors = new ArrayList<>(Arrays.asList(new Author(0, "Haavlek", "haavlek@hotmail.com", new Address(1, "Underhaugvegen37", 7509)), new Author(1, "Maggieb", "maggieb@hotmail.com", new Address(1, "Skolegata 1", 7508))));
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public Author getAuthorByName(String name) {
        Author current = null;
        for(int i = 0; i < authors.size(); i++) {
            if(authors.get(i).getName().equals(name)) {
                current = authors.get(i);
            }
        }
        return current;
    }

    public Author getAuthorById(int id) {
        Author current = null;
        for(int i = 0; i < authors.size(); i++) {
            if(authors.get(i).getId() == id) {
                current = authors.get(i);
            }
        }
        return current;
    }

    public Author addAuthor(Author author) {
        author.setId(authors.size());
        authors.add(author);
        return author;
    }

    public Author updateAuthor(Author author, int id) {
        for(int i = 0; i < authors.size(); i++) {
            Author current = authors.get(i);
            if(current.getId() == id) {
                authors.set(i, author);
                return author;
            }
        }
        return null;
    }

    public void deleteAuthor(int id) {
        for(int i = 0; i < authors.size(); i++) {
            Author current = authors.get(i);
            if(current.getId() == id) {
                authors.remove(current);
            }
        }
    }
}