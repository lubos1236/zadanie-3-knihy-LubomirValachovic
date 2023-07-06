package sk.stuba.fei.uim.oop.assignment3.book;

import lombok.Data;
import lombok.NoArgsConstructor;
import sk.stuba.fei.uim.oop.assignment3.author.Author;

import javax.persistence.*;

@Entity @Data @NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @ManyToOne
    private Author author;
    private int pages,amount,lendCount;

    public Book(String name, String description, Author author, int pages, int amount, int lendCount) {
        this.name = name;
        this.description = description;
        this.pages = pages;
        this.amount = amount;
        this.lendCount = lendCount;
        this.author = author;
        this.author.addBook(this);
    }

}
