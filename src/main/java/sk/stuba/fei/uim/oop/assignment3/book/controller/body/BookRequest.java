package sk.stuba.fei.uim.oop.assignment3.book.controller.body;

import lombok.Getter;

@Getter
public class BookRequest {
    private String name;
    private String description;
    private Long author;
    private int pages,amount,lendCount;
}
