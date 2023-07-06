package sk.stuba.fei.uim.oop.assignment3.list;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IListRepository extends JpaRepository<LendingList,Long> {
    List<LendingList> findAll();
}
