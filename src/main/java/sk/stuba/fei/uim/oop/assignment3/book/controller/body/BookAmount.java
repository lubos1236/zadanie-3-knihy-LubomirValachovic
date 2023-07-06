package sk.stuba.fei.uim.oop.assignment3.book.controller.body;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sk.stuba.fei.uim.oop.assignment3.book.Book;

@Getter @AllArgsConstructor @NoArgsConstructor
public class BookAmount {
    private int amount;

    public BookAmount(Book b) {
        this.amount = b.getAmount();
    }
}
