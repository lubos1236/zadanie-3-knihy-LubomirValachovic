package sk.stuba.fei.uim.oop.assignment3.list.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.book.controller.body.BookIdRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.list.controller.body.ListResponse;
import sk.stuba.fei.uim.oop.assignment3.list.service.ListService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/list")
public class ListController {
    @Autowired
    private ListService service;

    @GetMapping()
    public List<ListResponse> getAllLists(){
        return this.service.getAll().stream().map(ListResponse::new).collect(Collectors.toList());
    }
    @PostMapping()
    public ResponseEntity<ListResponse> createList(){
        return new ResponseEntity<>(new ListResponse(this.service.createList()), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ListResponse getListById(@PathVariable("id")Long id)throws NotFoundException {
        return new ListResponse(this.service.getListById(id));
    }
    @DeleteMapping("/{id}")
    public void deleteList(@PathVariable("id")Long id) throws NotFoundException{
        this.service.deleteList(id);
    }
    @PostMapping("/{id}/add")
    public ListResponse addBookToList(@PathVariable("id")Long id, @RequestBody BookIdRequest request) throws NotFoundException, IllegalOperationException {
        return new ListResponse(this.service.addBookToList(id,request));
    }
    @DeleteMapping("/{id}/remove")
    public void removeBookFromList(@PathVariable("id")Long id, @RequestBody BookIdRequest request) throws NotFoundException{
        this.service.removeBookFromList(id,request);
    }
    @GetMapping("/{id}/lend")
    public void lendList(@PathVariable("id")Long id)throws NotFoundException,IllegalOperationException {
        this.service.lendList(id);
    }

}
