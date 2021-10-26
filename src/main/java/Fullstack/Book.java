package Fullstack;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Book {
    private int id;
    private String name;
    private String publisher;
    private List<Author> authors = new ArrayList<Author>();

    public Book() {

    }

    public Book(int id, String name, String publisher) {
        this.id = id;
        this.name = name;
        this.publisher = publisher;
        //this.authors = new ArrayList<Author>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<Author> authors) {
        this.authors = authors;
    }
}
