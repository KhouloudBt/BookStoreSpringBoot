package tn.esprit.bookstore.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Member {
    @Id
    private int id;
}
