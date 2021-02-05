package tn.esprit.bookstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.bookstore.dao.WriterDesireRepository;
import tn.esprit.bookstore.entities.WriterDesire;
import java.util.List;

    @Service
    public class WriterDesireService {

        @Autowired
        WriterDesireRepository WriterDesireRep;

        public List<WriterDesire> getWriterDesires(){
            return WriterDesireRep.findAll();
        }


        public void deleting(long id) {
            WriterDesireRep.deleteById(id);
        }

    }