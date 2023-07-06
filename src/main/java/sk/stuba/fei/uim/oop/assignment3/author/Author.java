package sk.stuba.fei.uim.oop.assignment3.author;

import lombok.Data;
import lombok.NoArgsConstructor;
import sk.stuba.fei.uim.oop.assignment3.book.Book;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Data @NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @OneToMany
    private List<Book> books;

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.books=new ArrayList<>();
    }
    public void addBook(Book b){
        if (!books.contains(b)) books.add(b);
    }

}
