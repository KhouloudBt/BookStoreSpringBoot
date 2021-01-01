package tn.esprit.bookstore.views;

import tn.esprit.bookstore.entities.Book;
import tn.esprit.bookstore.entities.Category;

import java.util.List;

public interface IBookService {

    List<Book> retrieveAllBooks();
    Book addBook(Book book);
    void deleteBook(String id);
    Book updateBook(Category u);
    Book retrieveBookById(String id);
    List<Book> retrieveBookByTitle(String name);
}
