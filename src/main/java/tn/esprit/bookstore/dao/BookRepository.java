package tn.esprit.bookstore.dao;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.bookstore.entities.Book;

import java.util.List;

public interface BookRepository extends CrudRepository<Book,String> {
    Book findBookByTitle(String title);
    List<Book> SearchBooksByTitle(String title);


}
