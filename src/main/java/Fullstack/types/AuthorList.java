package Fullstack.types;

import Fullstack.Author;

//Type-class used for converting Authors to AuthorList - which does not contain a reference to the Book-list
//Used for extending existing classes with new functionality
public class AuthorList {
    private int id;
    private String name;
    private String email;

    public AuthorList(Author author) {
        this.id = author.getId();
        this.name = author.getName();
        this.email = author.getEmail();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
