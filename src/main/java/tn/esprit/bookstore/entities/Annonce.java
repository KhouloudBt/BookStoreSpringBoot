package tn.esprit.bookstore.entities;


import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.util.Date;

public class Annonce  implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private Date date_debut;
    private Date date_fin;
    private  Boolean etat;
    private Book livre;
    private String description;

    public Annonce() {}


    public Annonce(long id, Date date_debut, Date date_fin, Boolean etat, Book livre, String description) {
        this.id = id;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.etat = etat;
        this.livre = livre;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public Boolean getEtat() {
        return etat;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }

    public Book getLivre() {
        return livre;
    }

    public void setLivre(Book livre) {
        this.livre = livre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Annonce{" +
                "id=" + id +
                ", date_debut=" + date_debut +
                ", date_fin=" + date_fin +
                ", etat=" + etat +
                ", livre=" + livre.toString() +
                ", description='" + description + '\'' +
                '}';
    }
}
