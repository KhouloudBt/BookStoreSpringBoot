package tn.esprit.bookstore.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.bookstore.dao.OfferRepository;
import tn.esprit.bookstore.entities.Offer;
import tn.esprit.bookstore.utilities.RegexTests;
import tn.esprit.bookstore.views.IOfferService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service

public class OfferService implements IOfferService {

    @Autowired
    OfferRepository offerRepository;

    private static final Logger logger = Logger.getLogger(OfferService.class);


    @Override
    public List<Offer> retrieveAllOffer() {
        List<Offer> offers = new ArrayList<Offer>();
        offerRepository.findAll().forEach(offers::add);
        logger.info("retrieved list of categories"+offers);
        return offers;

    }

    @Override
    public Offer addOffer(Offer o) {
        if ((RegexTests.isValidDate(o.getDateDebut())) &&
                (RegexTests.isValidDate(o.getDateFin()))&&(Integer.parseInt(o.getDateDebut())<Integer.parseInt(o.getDateFin()))) {
            logger.info("Adding Offer" + o);
            return offerRepository.save(o);
        }
        else
        {
            logger.warn("check the dates " );
            return null;

        }

    }

    @Override
    public void deleteOffer(Offer o) {
        offerRepository.delete(o);


    }

    @Override
    public Offer updateOffer(Offer o) {
        return null;
    }



    @Override
    public List<Offer> retrieveOfferByName(String name) {
        List<Offer> o = this.retrieveAllOffer().stream()
                .filter(c->c.getName().toUpperCase().contains(name.toUpperCase()))
                .collect(Collectors.toList());
        if (o==null)
            logger.warn("this offer doesn't exist !");
        else
            logger.info("retrieved offers: "+o);
        return o;

    }

    @Override
    public Offer retrieveOfferByid(long id) {
        Optional<Offer> o= offerRepository.findById(id);
        if (o.get() ==null)
            logger.error("offer with id "+id+" doesn't exist");
        else logger.info("Retrieved offer"+o.get());
        return o.get();
    }


    @Override
    public boolean OfferNameDoesntExist(String name) {
        return this.retrieveAllOffer().stream()
                .map(c->c.getName().toUpperCase())
                .noneMatch(c->c.equals(name.toUpperCase()));
    }

    }

