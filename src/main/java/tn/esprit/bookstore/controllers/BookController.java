 package tn.esprit.bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.bookstore.entities.ArchiveBook;
import tn.esprit.bookstore.entities.Book;

import tn.esprit.bookstore.views.IBookService;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = "Book")
public class BookController  {

     @Autowired
     IBookService bookService;

    @GetMapping("/getAll")
     public ResponseEntity<Collection<Book>> retrieveAllBooks() {
        Collection<Book> books =bookService.retrieveAllBooks();
        return ResponseEntity.ok(books);
     }


    @PostMapping("/newBook")
    public ResponseEntity<Book> addBook(@Valid @RequestBody Book book) throws URISyntaxException {
        Book result = bookService.addBook(book);
        return ResponseEntity.created(new URI("/newBook" + result.getIsbn())).body(result);
    }


    @PostMapping("/ArchiveBook/{id}")
    public ResponseEntity<ArchiveBook> archiveBook(@Valid @PathVariable(name="id") String id) throws URISyntaxException {
             ArchiveBook result= bookService.archiveBook(id);
             return ResponseEntity.created(new URI("/archivedBook" + result.getId())).body(result);
         }


    @PutMapping(value="/updateBook" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> updateBook(@Valid @RequestBody Book b) {
       Book book =bookService.updateBook(b);
        return ResponseEntity.ok(book);
    }

    @GetMapping("/getByID/{id}")
    public ResponseEntity<Book> retrieveBookById(@PathVariable(name="id") String id) {
        Book book  =bookService.retrieveBookById(id);
        return ResponseEntity.ok(book);
    }
    @GetMapping("/getBytitle/{title}")
    public ResponseEntity <Collection<Book>> retrieveBookBytitle(@PathVariable(name="title") String title) {
              return ResponseEntity.ok(bookService.retrieveBookByTitle(title));
    }
     @GetMapping("/retrieveArchivedBook")
     public ResponseEntity<?> retrieveArchivedBook() {
         List<ArchiveBook> books  =bookService.retrieveArchivedBooks();
         return ResponseEntity.ok(books);
     }

 }