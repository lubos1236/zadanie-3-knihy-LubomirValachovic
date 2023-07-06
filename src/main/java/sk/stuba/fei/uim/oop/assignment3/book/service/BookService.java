package sk.stuba.fei.uim.oop.assignment3.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.author.service.IAuthorService;
import sk.stuba.fei.uim.oop.assignment3.book.Book;
import sk.stuba.fei.uim.oop.assignment3.book.IBookRepository;
import sk.stuba.fei.uim.oop.assignment3.book.controller.body.BookAmount;
import sk.stuba.fei.uim.oop.assignment3.book.controller.body.BookEditRequest;
import sk.stuba.fei.uim.oop.assignment3.book.controller.body.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService{
    @Autowired
    private IBookRepository repository;
    @Autowired
    private IAuthorService authorService;
    @Override
    public List<Book> getAll(){return this.repository.findAll();}

    @Override
    public Book createBook(BookRequest request) throws NotFoundException{
        Book book=new Book(request.getName(), request.getDescription(),this.authorService.getAuthorById(request.getAuthor()), request.getPages(), request.getAmount(), request.getLendCount());
        return this.repository.save(book);
    }
    @Override
    public Book getBookById(Long id) throws NotFoundException {
        Optional<Book> optionalBook=this.repository.findById(id);
        if(optionalBook.isPresent())
            return optionalBook.get();
        else throw new NotFoundException();
    }
    @Override
    public Book updateBook(Long id, BookEditRequest request) throws NotFoundException{
        Book b=getBookById(id);
        if(request.getName()!=null) b.setName(request.getName());
        if(request.getDescription()!=null) b.setDescription(request.getDescription());
        if(request.getAuthor()!=0) {
            b.getAuthor().getBooks().remove(b);
            b.setAuthor(this.authorService.getAuthorById(request.getAuthor()));
            b.getAuthor().addBook(b);
        }
        if(request.getPages()!=0) b.setPages(request.getPages());
        return b;
    }
    @Override
    public void deleteBook(Long id) throws NotFoundException {
        Book b=getBookById(id);
        b.getAuthor().getBooks().remove(b);
        this.repository.delete(b);
    }

    @Override
    public Book addBookAmount(Long id, BookAmount bookAmount) throws NotFoundException{
        Book b=getBookById(id);
        b.setAmount(bookAmount.getAmount()+b.getAmount());
        return b;
    }
}
