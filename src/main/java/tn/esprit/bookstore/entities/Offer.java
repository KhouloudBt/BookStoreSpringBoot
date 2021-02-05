package tn.esprit.bookstore.entities;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Table
public class Offer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String Name;
    private String Desc;
    private String DateDebut;
    private String DateFin;


    public Offer(long id, String name, String desc, String dateDebut, String dateFin) {
        this.id = id;
        Name = name;
        Desc = desc;
        DateDebut = dateDebut;
        DateFin = dateFin;
    }

    public Offer(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public String getDateDebut() {
        return DateDebut;
    }

    public void setDateDebut(String dateDebut) {
        DateDebut = dateDebut;
    }

    public String getDateFin() {
        return DateFin;
    }

    public void setDateFin(String dateFin) {
        DateFin = dateFin;
    }
}

