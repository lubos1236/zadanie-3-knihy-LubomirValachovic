package sk.stuba.fei.uim.oop.assignment3.author.controller.body;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.author.Author;
import sk.stuba.fei.uim.oop.assignment3.book.Book;

import javax.persistence.ElementCollection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class AuthorResponse {
    private Long id;
    private String name;
    private String surname;
    @ElementCollection
    private List<Long> books;

    public AuthorResponse(Author a) {
        this.id = a.getId();
        this.name = a.getName();
        this.surname = a.getSurname();
        this.books= a.getBooks().stream().map(Book::getId).collect(Collectors.toList());
    }
}
