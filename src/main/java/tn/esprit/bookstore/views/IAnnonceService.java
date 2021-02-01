package tn.esprit.bookstore.views;


import java.util.Date;
import java.util.List;
import tn.esprit.bookstore.entities.Annonce;
import tn.esprit.bookstore.entities.Book;

public interface IAnnonceService {

    List<Annonce> retrieveAllAnnonce();

    public Annonce saveAnnonce(Annonce c) ;

    public Annonce updateAnnonce(Annonce c,String id) ;

    public void removeAnnonce(String id);

    Annonce retrieveAnnonceById(String id);

    Annonce retrieveAnnonceByBook(Book name);

    List<Annonce> retrieveBookByDate(Date d);
}
