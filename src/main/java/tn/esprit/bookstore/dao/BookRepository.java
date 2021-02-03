package tn.esprit.bookstore.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.bookstore.entities.Book;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book,String> {
    //Book findBookByTitle(String title);
   // List<Book> SearchBooksByTitle(String title);


}
