package tn.esprit.bookstore.entities;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Collection;


@Entity
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(columnDefinition = "varchar(10000) default 'No Description provided for this category'")
    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    private Collection<Book> books;

    public Category(String name, String description) {
        this.name=name;
        this.description=description;
    }

    public Category() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
