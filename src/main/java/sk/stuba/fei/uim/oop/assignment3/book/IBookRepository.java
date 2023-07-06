package sk.stuba.fei.uim.oop.assignment3.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book,Long> {
    List<Book> findAll();
}
