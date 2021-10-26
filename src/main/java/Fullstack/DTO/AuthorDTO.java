package Fullstack.DTO;

import Fullstack.types.BookList;
import Fullstack.Address;
import Fullstack.Author;

import java.util.List;
import java.util.stream.Collectors;

//Data-Transfer-Object class - used to return a AuthorDTO-object instead of an Author - which contains a reference to a list of BookLists instead of Books
public class AuthorDTO {
    private int id;
    private String name;
    private String email;
    private Address address;
    private List<BookList> bookList;

    //Constructor with an Author as parameter, to access the object variables of an Author
    public AuthorDTO(Author author) {
        this.id = author.getId();
        this.name = author.getName();
        this.email = author.getEmail();
        this.address = author.getAddress();
        this.bookList = author.getBooks().stream().map(s -> new BookList(s)).collect(Collectors.toList());  //Stream for mapping all Books in the authors Book-list to BookList-objects
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public List<BookList> getBookList() {
        return bookList;
    }
}
