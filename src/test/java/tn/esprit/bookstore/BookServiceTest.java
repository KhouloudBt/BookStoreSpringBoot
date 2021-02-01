package tn.esprit.bookstore;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.bookstore.entities.Book;
import tn.esprit.bookstore.entities.Category;
import tn.esprit.bookstore.views.IBookService;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {

    @Autowired
    IBookService bookService;



    public List<Book> retrieveAllBooks() {
        return null;
    }


    public Book addBook(Book book) {
        return null;

    }

    public void archiveBook(String id) {

    }

    public Book updateBook(Category u) {
        return null;

    }


    public Book retrieveBookById(String id) {
        return null;

    }

    public List<Book> retrieveBookByTitle(String name) {
        return null;

    }
}