package sk.stuba.fei.uim.oop.assignment3.author.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.author.controller.body.AuthorRequest;
import sk.stuba.fei.uim.oop.assignment3.author.controller.body.AuthorResponse;
import sk.stuba.fei.uim.oop.assignment3.author.service.AuthorService;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService service;

    @GetMapping()
    public List<AuthorResponse> getAllAuthors(){
        return this.service.getAll().stream().map(AuthorResponse::new).collect(Collectors.toList());
    }
    @PostMapping()
    public ResponseEntity<AuthorResponse> createAuthor(@RequestBody AuthorRequest request){
        return new ResponseEntity<>(new AuthorResponse(this.service.createAuthor(request)), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public AuthorResponse getAuthorById(@PathVariable("id") Long id) throws NotFoundException {
        return new AuthorResponse(this.service.getAuthorById(id));
    }
    @PutMapping("/{id}")
    public AuthorResponse updateAuthor(@PathVariable("id") Long id, @RequestBody AuthorRequest request) throws NotFoundException{
        return new AuthorResponse(this.service.updateAuthor(id,request));
    }
    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable("id") Long id) throws NotFoundException{
        this.service.deleteAuthor(id);
    }

}
