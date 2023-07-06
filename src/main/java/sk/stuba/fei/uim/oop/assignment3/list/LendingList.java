package sk.stuba.fei.uim.oop.assignment3.list;

import lombok.Data;
import lombok.NoArgsConstructor;
import sk.stuba.fei.uim.oop.assignment3.book.Book;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Data
public class LendingList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<Book> books;
    private boolean lended;

    public LendingList() {
        this.lended = false;
        this.books=new ArrayList<>();
    }
    public void addBook(Book b)throws IllegalOperationException {
        if (books.contains(b)) throw new IllegalOperationException();
        else books.add(b);
    }
    public void removeBook(Book b)throws NotFoundException {
        if (!books.contains(b)) throw new NotFoundException();
        else books.remove(b);
    }
}

