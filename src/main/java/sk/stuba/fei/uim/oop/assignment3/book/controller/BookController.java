package sk.stuba.fei.uim.oop.assignment3.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.book.controller.body.BookAmount;
import sk.stuba.fei.uim.oop.assignment3.book.controller.body.BookEditRequest;
import sk.stuba.fei.uim.oop.assignment3.book.controller.body.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.book.controller.body.BookResponse;
import sk.stuba.fei.uim.oop.assignment3.book.service.BookService;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService service;
    @GetMapping()
    public List<BookResponse> getAllAuthors(){
        return this.service.getAll().stream().map(BookResponse::new).collect(Collectors.toList());
    }
    @PostMapping()
    public ResponseEntity<BookResponse> createBook(@RequestBody BookRequest request) throws NotFoundException{
        return new ResponseEntity<>(new BookResponse(this.service.createBook(request)),HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public BookResponse getBookById(@PathVariable("id") Long id) throws NotFoundException {
        return new BookResponse(this.service.getBookById(id));
    }
    @PutMapping("/{id}")
    public BookResponse updateBook(@PathVariable("id") Long id, @RequestBody BookEditRequest request)throws NotFoundException{
        return new BookResponse(this.service.updateBook(id,request));
    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") Long id)throws NotFoundException{
        this.service.deleteBook(id);
    }
    @GetMapping("/{id}/amount")
    public BookAmount getBookAmount(@PathVariable("id")Long id)throws NotFoundException{
        return new BookAmount(this.service.getBookById(id));
    }
    @PostMapping("/{id}/amount")
    public BookAmount addBookAmount(@PathVariable("id")Long id,@RequestBody BookAmount bookAmount)throws NotFoundException{
        return new BookAmount(this.service.addBookAmount(id,bookAmount));
    }
    @GetMapping("/{id}/lendCount")
    public BookAmount getLendCound(@PathVariable("id")Long id)throws NotFoundException{
        return new BookAmount(this.service.getBookById(id).getLendCount());
    }

}
