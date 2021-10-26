package Fullstack.web;

import Fullstack.Author;
import Fullstack.service.AuthorBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import Fullstack.Book;

import java.util.List;

@org.springframework.web.bind.annotation.RestController

@RequestMapping("/authors/{id}/books")

//Controller class for handling actions between the Author and Book classes. Creates a many-to-many relationship between them.
public class AuthorBooksController {

    @Autowired
    private AuthorBooksService authorBooksService;

    @PostMapping
    public int updateBooks(@RequestBody Book newBookData, @PathVariable("id") int id) {
        return authorBooksService.updateAuthorBook(id, newBookData);
    }

    @GetMapping
    public List<Book> findBooksByAuthor(@PathVariable("id") int id) {
        return authorBooksService.findBooksByAuthor(id);
    }

    @DeleteMapping("/{id}")
    public void removeBookByAuthor(@PathVariable("id") int id, @RequestParam int bookId) {
        authorBooksService.removeBookByAuthor(id, bookId);
    }
}

