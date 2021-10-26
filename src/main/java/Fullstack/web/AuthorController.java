package Fullstack.web;

import Fullstack.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import Fullstack.Author;

import java.util.List;

@org.springframework.web.bind.annotation.RestController

@RequestMapping("/authors")

//Controller-class with public methods with links to possible user-actions
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/{name}")
    public Author getAuthor(@PathVariable("name") String name) {
        return authorService.getAuthorByName(name);
    }

    @GetMapping
    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    @PostMapping
    public Author addAuthor(@RequestBody Author author) {
        return authorService.addAuthor(author);
    }

    @PutMapping("/{id}")
    public int updateAuthor(@RequestParam Author newAuthorData, @PathVariable("id") int id) {
        return authorService.updateAuthor(newAuthorData, id);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable("id") int id) {
        authorService.deleteAuthor(id);
    }

}
