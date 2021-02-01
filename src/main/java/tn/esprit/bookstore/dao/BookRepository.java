package tn.esprit.bookstore.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.bookstore.entities.Book;

import java.util.Collection;


@Repository
public interface BookRepository extends CrudRepository<Book,String> {


    @Query(value = "SELECT b FROM Book b WHERE b.isbn like %:isbn%")
	Book findByIsbn(@Param("isbn") String isbn);


}
