package tn.esprit.bookstore.entities;

import javax.persistence.*;

@Entity
public class Promition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Book book;
    private String lib;

    public Promition(Book book, String lib) {
        this.book = book;
        this.lib = lib;
    }

    public Promition(Book book) {
        this.book = book;
        this.lib = "Free";
    }

    public Promition() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getLib() {
        return lib;
    }

    public void setLib(String lib) {
        this.lib = lib;
    }

    @Override
    public String toString() {
        return "Promition{" +
                "id=" + id +
                ", book=" + book +
                ", lib='" + lib + '\'' +
                '}';
    }
}
