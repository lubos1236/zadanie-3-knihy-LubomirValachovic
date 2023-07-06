package sk.stuba.fei.uim.oop.assignment3.author.service;


import sk.stuba.fei.uim.oop.assignment3.author.Author;
import sk.stuba.fei.uim.oop.assignment3.author.controller.body.AuthorRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;

public interface IAuthorService {
    List<Author> getAll();
    Author createAuthor(AuthorRequest request);
    Author getAuthorById(Long id) throws NotFoundException;
    Author updateAuthor(Long id,AuthorRequest request) throws NotFoundException;
    void deleteAuthor(Long id) throws NotFoundException;
}
