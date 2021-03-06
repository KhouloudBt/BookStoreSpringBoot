package tn.esprit.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.annotation.Resource;


@ConfigurationPropertiesScan
@EnableAspectJAutoProxy
@SpringBootApplication
public class BookstoreApplication  {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);

    }



}
