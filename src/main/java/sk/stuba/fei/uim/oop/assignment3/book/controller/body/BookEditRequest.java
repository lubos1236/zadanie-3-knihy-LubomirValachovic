package sk.stuba.fei.uim.oop.assignment3.book.controller.body;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class BookEditRequest {
    private String name;
    private String description;
    private Long author;
    private int pages;
}
