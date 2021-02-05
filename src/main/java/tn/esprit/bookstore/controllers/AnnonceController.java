package tn.esprit.bookstore.controllers;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tn.esprit.bookstore.entities.Annonce;
import tn.esprit.bookstore.services.AnnonceService;


@RestController
@RequestMapping(path = "Annonce")
public class AnnonceController {
    @Autowired
    private AnnonceService annonceService;

/************************CRUD************************/
    //récuperation des annonces (en utilisant le JPA Paging)
    @GetMapping("/")
    public List<Annonce> retrieveAllAnnonce(){
        return annonceService.retrieveAllAnnonce();}

    //Insert
    @PostMapping(value="/add" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public Annonce creerAnnonce(@RequestBody Annonce c) {
        return annonceService.saveAnnonce(c);
    }

    //Modifier
    @PutMapping(path="/update/{id}")
    public Annonce updateA(@RequestBody Annonce c, @PathVariable String id) {

        return annonceService.updateAnnonce(c,id);
    }

    //Supprimer
    @DeleteMapping(path="/delete/{id}")
    public boolean delete(@PathVariable(name="id") String id) {
        annonceService.removeAnnonce(id);
        return true;
    }
    //récuperation d'une annonce via son ID
    @GetMapping("/byid/{id}")
    public Annonce retrieveById(@PathVariable(name="id") String id){
        return annonceService.retrieveAnnonceById(id);}

    //récuperation des annonces via selon ses états
    @GetMapping("/byetat/{etat}")
    public List<Annonce> retrieveByDate(@PathVariable(name="etat") String etat){
        return annonceService.retrieveAnnonceDispo(Boolean.parseBoolean(etat));}

    //récuperation les annonces d'aujourd'hui  (en utilisant le JPA Query)
    @GetMapping("/Qannonce")
    public List<Annonce> retrieveAnnonces(){
        return annonceService.retrieveNewAnn();}


    //récuperation les annonces disponibles  (en utilisant le JPA Query)
    @GetMapping("/DispoAnnonce")
    public List<Annonce> retrieveDispoAnnonces(){
        return annonceService.retrieveDispoAnn();}
/****************************************************/
}
