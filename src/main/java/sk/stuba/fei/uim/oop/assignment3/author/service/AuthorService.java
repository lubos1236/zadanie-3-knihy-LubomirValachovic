package sk.stuba.fei.uim.oop.assignment3.author.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.author.Author;
import sk.stuba.fei.uim.oop.assignment3.author.IAuthorRepository;
import sk.stuba.fei.uim.oop.assignment3.author.controller.body.AuthorRequest;
import sk.stuba.fei.uim.oop.assignment3.book.IBookRepository;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements IAuthorService{

    @Autowired
    private IAuthorRepository repository;
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<Author> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Author createAuthor(AuthorRequest request) {
        Author a= new Author(request.getName(), request.getSurname());
        return this.repository.save(a);
    }

    @Override
    public Author getAuthorById(Long id) throws NotFoundException {
        Optional<Author> authorOptional=this.repository.findById(id);
        if (authorOptional.isPresent())
            return authorOptional.get();
        throw new NotFoundException();
    }

    @Override
    public Author updateAuthor(Long id,AuthorRequest request) throws NotFoundException{
        Author a=this.getAuthorById(id);
        if(request.getName()!=null) a.setName(request.getName());
        if(request.getSurname()!=null) a.setSurname(request.getSurname());
        return this.repository.save(a);
    }

    @Override
    public void deleteAuthor(Long id) throws NotFoundException{
        Author a=this.getAuthorById(id);
        this.bookRepository.deleteAll(a.getBooks());
        this.repository.delete(a);
    }
}
