package sk.stuba.fei.uim.oop.assignment3.book.service;

import sk.stuba.fei.uim.oop.assignment3.book.Book;
import sk.stuba.fei.uim.oop.assignment3.book.controller.body.BookAmount;
import sk.stuba.fei.uim.oop.assignment3.book.controller.body.BookEditRequest;
import sk.stuba.fei.uim.oop.assignment3.book.controller.body.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;

public interface IBookService {
    List<Book> getAll();
    Book createBook(BookRequest request) throws NotFoundException;
    Book getBookById(Long id) throws NotFoundException;
    Book updateBook(Long id, BookEditRequest request) throws NotFoundException;
    void deleteBook(Long id)throws NotFoundException;
    Book addBookAmount(Long id, BookAmount bookAmount) throws NotFoundException;
}
