package tn.esprit.bookstore.views;

import tn.esprit.bookstore.entities.Offer;

import java.util.List;

public interface IOfferService {

    List<Offer> retrieveAllOffer();
    Offer addOffer(Offer o);
    void deleteOffer(Offer o);
    Offer updateOffer(Offer o);
    List<Offer> retrieveOfferByName(String name);
    boolean OfferNameDoesntExist(String name);
}
