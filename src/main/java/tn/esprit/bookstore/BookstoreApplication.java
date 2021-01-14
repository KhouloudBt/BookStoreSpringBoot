package tn.esprit.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.log4j.Logger;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import tn.esprit.bookstore.services.FilesStorageService;
import tn.esprit.bookstore.utilities.RegexTests;

import javax.annotation.Resource;

@ConfigurationPropertiesScan
@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {
    @Resource
    FilesStorageService storageService;

    @Override
    public void run(String... arg) throws Exception {
        storageService.deleteAll();
        storageService.init();
    }

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);

    }



}
