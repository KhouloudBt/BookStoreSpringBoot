package tn.esprit.bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.bookstore.entities.Offer;
import tn.esprit.bookstore.services.OfferService;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = "Offer")

public class OfferController {
    @Autowired
    OfferService offerService;
    @GetMapping("/getAll")
    public ResponseEntity<?> retrieveAlloffer() {
        try {
            Collection<Offer> offers =offerService.retrieveAllOffer();
            return ResponseEntity.ok(offers);
        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/newOffer")
    public ResponseEntity<Offer> addOffer(@Valid @RequestBody Offer offer) throws URISyntaxException {

        Offer result = offerService.addOffer(offer);
        return ResponseEntity.created(new URI("/newOffer" + result.getId())).body(result);
    }

    @PutMapping("/updateOffer/{id}")
    public ResponseEntity<?> updateOffer(@Valid @RequestBody Offer newOffer, @PathVariable("id") long id) {
        try {
            Offer offer = offerService.retrieveOfferByid(id);
            offer.setName(newOffer.getName());
            offer.setDesc(newOffer.getDesc());
            offer.setDateDebut(newOffer.getDateDebut());
            offer.setDateFin(newOffer.getDateFin());
            Offer result = offerService.addOffer(offer);
            return ResponseEntity.ok().body(result);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while updating Offer"+ex.getMessage());
        }
    }

    @DeleteMapping("/removeOffer/{id}")
    public ResponseEntity<?> deleteOffer(@PathVariable("offer") long id) {
        try {
            Offer offer = offerService.retrieveOfferByid(id);
            offerService.deleteOffer(offer);
            return ResponseEntity.ok().body("Deleted Offer: "+offer);
        }
        catch (Exception ex)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error while deleting offer !");
        }
    }


    @GetMapping("/getOfferByName/{OfferName}")
    public ResponseEntity<?> retrieveOfferByName( @PathVariable(name="OfferName") String name) {
        List<Offer> offers;
        try {
            offers = offerService.retrieveOfferByName(name);
            return ResponseEntity.ok().body(offers);
        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().body("Error while retrieveing categories with name :" +name);
        }
    }
}
