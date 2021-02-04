package tn.esprit.bookstore.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class WriterDesire {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
private String writer;
private int nbr;

    public WriterDesire(String writer, int nbr) {
        this.writer = writer;
        this.nbr = nbr;
    }

    public WriterDesire() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getNbr() {
        return nbr;
    }

    public void setNbr(int nbr) {
        this.nbr = nbr;
    }

    @Override
    public String toString() {
        return "WriterDesire{" +
                "id=" + id +
                ", writer='" + writer + '\'' +
                ", nbr=" + nbr +
                '}';
    }
}
