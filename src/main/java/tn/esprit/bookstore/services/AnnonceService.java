package tn.esprit.bookstore.services;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import tn.esprit.bookstore.entities.Book;
import tn.esprit.bookstore.utilities.RegexTests;
import org.springframework.beans.factory.annotation.Autowired;
import sun.rmi.runtime.Log;
import tn.esprit.bookstore.dao.AnnonceRepository;
import tn.esprit.bookstore.entities.Annonce;
import tn.esprit.bookstore.views.IAnnonceService;

import java.util.Date;
import java.util.Optional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnnonceService implements IAnnonceService {
    @Autowired
    AnnonceRepository  annonceRepository;
    private static final Logger log = Logger.getLogger(AnnonceService.class);


    public List<Annonce> retrieveAllAnnonce() {
        return annonceRepository.findAll();
    }



    public Annonce saveAnnonce(Annonce c) {return annonceRepository.save(c);}



    public Annonce updateAnnonce(Annonce c, String id) {
        c.setId(Long.parseLong(id));
        return annonceRepository.save(c);
    }


    public void removeAnnonce(String id) {
        annonceRepository.deleteById(Long.parseLong(id));
    }


    @Override
    public Annonce retrieveAnnonceById(String id) {
        Optional<Annonce> an = annonceRepository.findById(Long.parseLong(id));
        if(an.get()==null)
            log.error("this "+id+"dose not exist");
        else
            log.info("the annonouncement is :" + an.get());
        return an.get();
    }



    public Annonce retrieveAnnonceByBook(Book name) {
        return null;
    }


    public List<Annonce> retrieveBookByDate(Date d) {
        return null;
    }


}
