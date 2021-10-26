package Fullstack.types;

import Fullstack.Book;

//Type-class used for converting Books to BookList - which does not contain a reference to the Author-list
//Used for extending existing classes with new functionality
public class BookList {
    private int id;
    private String name;
    private String publisher;

    public BookList(Book book) {
        this.id = book.getId();
        this.name = book.getName();
        this.publisher = book.getPublisher();
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
}
