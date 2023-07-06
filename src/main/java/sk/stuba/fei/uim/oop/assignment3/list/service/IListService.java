package sk.stuba.fei.uim.oop.assignment3.list.service;

import sk.stuba.fei.uim.oop.assignment3.book.controller.body.BookIdRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.list.LendingList;

import java.util.List;

public interface IListService {
    List<LendingList> getAll();
    LendingList createList();
    LendingList getListById(Long id) throws NotFoundException;
    void deleteList(Long id) throws NotFoundException;
    LendingList addBookToList(Long id, BookIdRequest request) throws NotFoundException, IllegalOperationException;
    void  removeBookFromList(Long id, BookIdRequest request) throws NotFoundException;
    void lendList(long id)throws NotFoundException,IllegalOperationException;
}
