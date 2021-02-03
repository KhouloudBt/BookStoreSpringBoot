package tn.esprit.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import tn.esprit.bookstore.entities.Session;
import tn.esprit.bookstore.utilities.RegexTests;


@SpringBootApplication
public class BookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);

        System.out.println(RegexTests.isAvalidCategory("Classics"));


    }



}
