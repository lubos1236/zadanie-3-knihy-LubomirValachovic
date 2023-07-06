package sk.stuba.fei.uim.oop.assignment3.book.controller.body;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.book.Book;

@Getter
public class BookResponse {
    private Long id;
    private String name;
    private String description;
    private Long author;
    private int pages,amount,lendCount;

    public BookResponse(Book b) {
        this.id = b.getId();
        this.name=b.getName();
        this.description=b.getDescription();
        this.author=b.getAuthor().getId();
        this.pages=b.getPages();
        this.amount=b.getAmount();
        this.lendCount=b.getLendCount();
    }
}
