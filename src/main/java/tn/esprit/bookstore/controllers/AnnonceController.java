package tn.esprit.bookstore.controllers;

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

    @GetMapping("/byid/{id}")
    public Annonce retrieveById(@PathVariable(name="id") String id){
        return annonceService.retrieveAnnonceById(id);}



}
