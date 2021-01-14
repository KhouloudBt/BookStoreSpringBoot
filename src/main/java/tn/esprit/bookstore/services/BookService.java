package tn.esprit.bookstore.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.bookstore.dao.Archive_bookRepository;
import tn.esprit.bookstore.dao.BookRepository;
import tn.esprit.bookstore.entities.Archive_Book;
import tn.esprit.bookstore.entities.Book;
import tn.esprit.bookstore.entities.Category;
import tn.esprit.bookstore.views.IBookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookService implements IBookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    Archive_bookRepository archive_bookRepository;

    private static final Logger logger = Logger.getLogger(CategoryService.class);


    @Override
    public List<Book> retrieveAllBooks() {
        List<Book> books = new ArrayList<Book>();
        bookRepository.findAll().forEach(books::add);
        logger.info("retrieved list of books: " + books);
        return books;
    }

    @Override
    public Book addBook(Book book) {

        return bookRepository.save(book);
    }

    @Override
    public void archiveBook(String id) {
        Book book = retrieveBookById(id);
        archive_bookRepository.save(new Archive_Book(book));
    }

    @Override
    public Book updateBook(Category u) {
        return null;
    }

    @Override
    public Book retrieveBookById(String id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.get() == null)
            logger.error("Couldn't find book with id :" + id);
        else logger.info("Retrieved book " + book.get());
        return book.get();
    }

    @Override
    public List<Book> retrieveBookByTitle(String name) {
        return null;
    }
}
