package tn.esprit.bookstore.views;


import java.util.List;
import tn.esprit.bookstore.entities.Annonce;

public interface IAnnonceService {

    List<Annonce> retrieveAllAnnonce();

    public Annonce saveAnnonce(Annonce c) ;

    public Annonce updateAnnonce(Annonce c) ;

    public Annonce removeAnnonce(long id);

    Annonce retrieveAnnonceById(String id);

    List<Annonce> retrieveAnnonceByBook(String name);

    List<Annonce> retrieveBookByDate(String name);
}
