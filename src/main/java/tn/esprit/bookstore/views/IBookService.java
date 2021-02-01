package tn.esprit.bookstore.views;

import tn.esprit.bookstore.entities.ArchiveBook;
import tn.esprit.bookstore.entities.Book;

import java.util.List;

public interface IBookService {

    List<Book> retrieveAllBooks();
    Book addBook(Book book);
    ArchiveBook archiveBook(String id);
    Book updateBook(Book book);
    Book retrieveBookById(String id);
    List<Book> retrieveBookByTitle(String name);
}
