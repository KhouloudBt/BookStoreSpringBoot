package tn.esprit.bookstore.entities;




import javax.persistence.*;
import java.util.Date;

@Entity
public class Annonce {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private Date date_debut;
    private Date date_fin;
    private  Boolean etat;
    @OneToOne(cascade = CascadeType.ALL)
    private Book livre;
    private String description;

    public Annonce() {}


    public Annonce(Date date_debut, Date date_fin, Boolean etat, Book livre, String description) {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Annonce annonce = (Annonce) o;

        if (id != annonce.id) return false;
        if (date_debut != null ? !date_debut.equals(annonce.date_debut) : annonce.date_debut != null) return false;
        if (date_fin != null ? !date_fin.equals(annonce.date_fin) : annonce.date_fin != null) return false;
        if (etat != null ? !etat.equals(annonce.etat) : annonce.etat != null) return false;
        if (livre != null ? !livre.equals(annonce.livre) : annonce.livre != null) return false;
        return description != null ? description.equals(annonce.description) : annonce.description == null;
    }







    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (date_debut != null ? date_debut.hashCode() : 0);
        result = 31 * result + (date_fin != null ? date_fin.hashCode() : 0);
        result = 31 * result + (etat != null ? etat.hashCode() : 0);
        result = 31 * result + (livre != null ? livre.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
