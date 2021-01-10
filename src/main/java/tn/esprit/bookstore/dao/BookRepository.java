package tn.esprit.bookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.bookstore.entities.Book;

//import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,String> {
    Book findBookByTitle(String title);
    //List<Book> SearchBooksByTitle(String title);
	Book findByIsbn(String isbn);


}
