package tn.esprit.bookstore.services;

import tn.esprit.bookstore.entities.Book;
import tn.esprit.bookstore.entities.Category;
import tn.esprit.bookstore.views.IBookService;

import java.util.List;

public class BookService implements IBookService {

    @Override
    public List<Book> retrieveAllBooks() {
        return null;
    }

    @Override
    public Book addBook(Book book) {
        return null;
    }

    @Override
    public void deleteBook(String id) {

    }

    @Override
    public Book updateBook(Category u) {
        return null;
    }

    @Override
    public Book retrieveBookById(String id) {
        return null;
    }

    @Override
    public List<Book> retrieveBookByTitle(String name) {
        return null;
    }
}
