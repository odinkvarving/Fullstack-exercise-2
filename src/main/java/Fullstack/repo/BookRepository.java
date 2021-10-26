package Fullstack.repo;

import org.springframework.stereotype.Repository;
import Fullstack.Book;
import java.util.ArrayList;
import java.util.Arrays;

//Repository-class with methods supporting creating, reading, updating and deleting of back-end-data
@Repository
public class BookRepository {
    private ArrayList<Book> books;

    public BookRepository() {
        //Dummy-objects
        this.books = new ArrayList<>(Arrays.asList(new Book(0, "Bibelen", "Norske bibliotek"), new Book(1, "Koranen", "Norske bibliotek")));
    }

    public Book getBookById(int id) {
        Book current = null;
        for(int i = 0; i < books.size(); i++) {
            if(books.get(i).getId() == id) {
                current = books.get(i);
            }
        }
        return current;
    }

    /*
    public Book getBookByName(String name) {
        Book current = null;
        for(int i = 0; i < books.size(); i++) {
            if(books.get(i).getName().equals(name)) {
                current = books.get(i);
            }
        }
        return current;
    }

     */

    public ArrayList<Book> getBooks() {
        return books;
    }

    public Book addBook(Book book) {
        book.setId(books.size());
        books.add(book);
        return book;
    }

    public Book updateBook(Book book, int id) {
        for(int i = 0; i < books.size(); i++) {
            Book current = books.get(i);
            if(current.getId() == id){
                books.set(i, book);
                return book;
            }
        }
        return null;
    }

    public void deleteBook(int id) {
        for(int i = 0; i < books.size(); i++) {
            Book current = books.get(i);
            if(current.getId() == id) {
                books.remove(current);
            }
        }
    }
}
