package Fullstack.web;

import Fullstack.types.BookList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import Fullstack.Book;
import Fullstack.DTO.BookDTO;
import Fullstack.service.BookService;

import java.util.List;

@org.springframework.web.bind.annotation.RestController

@RequestMapping("/books")

//Controller-class with public methods with links to possible user-actions
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{name}")
    public Book getBook(@PathVariable("name") String name) {
        return bookService.getBookByName(name);
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @PutMapping("{id}")
    public void updateBook(@RequestBody Book newBookData, @PathVariable("id") int id) {
        bookService.updateBook(newBookData, id);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") int id) {
        bookService.deleteBook(id);
    }
}
