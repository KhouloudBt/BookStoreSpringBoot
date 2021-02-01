package tn.esprit.bookstore.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.bookstore.dao.Archive_bookRepository;
import tn.esprit.bookstore.dao.BookRepository;
import tn.esprit.bookstore.entities.ArchiveBook;
import tn.esprit.bookstore.entities.Book;
import tn.esprit.bookstore.views.IBookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService implements IBookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    Archive_bookRepository archive_bookRepository;

    private final Logger logger = LoggerFactory.getLogger(BookService.class);


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
    public ArchiveBook archiveBook(String id) {
        Book book = retrieveBookById(id);
       return archive_bookRepository.save(new ArchiveBook(book));
    }



    @Override
    public Book updateBook(Book b) {
        Book book= this.retrieveBookById(b.getIsbn());
        bookRepository.delete(book);
       return bookRepository.save(b);
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
    public List<Book> retrieveBookByTitle(String title) {
        return this.retrieveAllBooks()
                .stream()
                .filter(b->b.getTitle().contains(title))
                .collect(Collectors.toList());
    }
}
