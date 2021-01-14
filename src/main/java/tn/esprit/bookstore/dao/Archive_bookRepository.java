package tn.esprit.bookstore.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.bookstore.entities.Archive_Book;

@Repository
public interface Archive_bookRepository extends CrudRepository<Archive_Book, Long>{
}