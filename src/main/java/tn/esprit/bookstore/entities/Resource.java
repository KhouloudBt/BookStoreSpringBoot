package tn.esprit.bookstore.entities;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
@Entity
public class Resource {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String fileName;
    private String fileType;
    @ManyToOne
    @JoinColumn(name="idBook", nullable=true)
    private Book book;

    @Lob
    private byte[] data;

    public Resource() {

    }

    public Resource(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }

    public Resource(String id, String fileName, String fileType, Book book, byte[] data) {
        this.id = id;
        this.fileName = fileName;
        this.fileType = fileType;
        this.book = book;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public byte[] getData() {
        return data;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}