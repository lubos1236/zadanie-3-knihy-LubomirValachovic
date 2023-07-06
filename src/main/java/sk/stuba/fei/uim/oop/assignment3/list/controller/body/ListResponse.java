package sk.stuba.fei.uim.oop.assignment3.list.controller.body;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.book.controller.body.BookResponse;
import sk.stuba.fei.uim.oop.assignment3.list.LendingList;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ListResponse {
    private Long id;
    private List<BookResponse> lendingList;
    private boolean lended;

    public ListResponse(LendingList l) {
        this.id = l.getId();
        this.lended = l.isLended();
        lendingList= l.getBooks().stream().map(BookResponse::new).collect(Collectors.toList());
    }
}