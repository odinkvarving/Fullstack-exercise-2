package Fullstack.DTO;

import Fullstack.Book;
import Fullstack.types.AuthorList;

import java.util.List;
import java.util.stream.Collectors;

//Data-Transfer-Object class - used to return a BookDTO-object instead of a Book - which contains a reference to a list of AuthorLists instead of Authors
public class BookDTO {
    private int id;
    private String name;
    private String publisher;
    private List<AuthorList> authorLists;

    //Constructor with a Book as parameter, to access the object variables of a Book
    public BookDTO(Book book) {
        this.id = book.getId();
        this.name = book.getName();
        this.publisher = book.getPublisher();
        this.authorLists = book.getAuthors().stream().map(s -> new AuthorList(s)).collect(Collectors.toList()); //Stream for mapping all Authors in the book's Author-list to AuthorList-objects

    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPublisher() {
        return publisher;
    }

    public List<AuthorList> getAuthorLists() {
        return authorLists;
    }
}
