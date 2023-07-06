package sk.stuba.fei.uim.oop.assignment3.list.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.book.controller.body.BookIdRequest;
import sk.stuba.fei.uim.oop.assignment3.book.service.BookService;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.list.IListRepository;
import sk.stuba.fei.uim.oop.assignment3.list.LendingList;

import java.util.List;
import java.util.Optional;

@Service
public class ListService implements IListService{

    @Autowired
    private IListRepository repository;
    @Autowired
    private BookService bookService;

    @Override
    public List<LendingList> getAll() {
        return this.repository.findAll();
    }

    @Override
    public LendingList createList() {
        return this.repository.save(new LendingList());
    }

    @Override
    public LendingList getListById(Long id) throws NotFoundException {
        Optional<LendingList> optionalLendingList=this.repository.findById(id);
        if (optionalLendingList.isPresent())
            return optionalLendingList.get();
        throw new NotFoundException();
    }

    @Override
    public void deleteList(Long id) throws NotFoundException {
        LendingList l=this.getListById(id);
        l.getBooks().forEach(book -> book.setLendCount(book.getLendCount()-1));
        this.repository.delete(l);
    }

    @Override
    public LendingList addBookToList(Long id, BookIdRequest request) throws NotFoundException, IllegalOperationException {
        LendingList l=this.getListById(id);
        if (l.isLended()) throw new IllegalOperationException();
        l.addBook(this.bookService.getBookById(request.getId()));
        return l;
    }

    @Override
    public void removeBookFromList(Long id, BookIdRequest request) throws NotFoundException {
        LendingList l=this.getListById(id);
        l.removeBook(this.bookService.getBookById(request.getId()));
    }

    @Override
    public void lendList(long id) throws NotFoundException, IllegalOperationException {
        LendingList l=this.getListById(id);
        if (l.isLended())throw new IllegalOperationException();
        l.getBooks().forEach(book -> book.setLendCount(book.getLendCount()+1));
        l.setLended(true);
    }
}
