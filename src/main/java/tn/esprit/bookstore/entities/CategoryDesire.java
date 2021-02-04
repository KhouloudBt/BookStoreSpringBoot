package tn.esprit.bookstore.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class CategoryDesire {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String category;
    private int nbr;

    public CategoryDesire(String category, int nbr) {
        this.category = category;
        this.nbr = nbr;
    }

    public CategoryDesire() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getNbr() {
        return nbr;
    }

    public void setNbr(int nbr) {
        this.nbr = nbr;
    }

    @Override
    public String toString() {
        return "CategoryDesire{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", nbr=" + nbr +
                '}';
    }
}
