package pl.coderslab.charity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("pl.coderslab")
public class CharityApplication {

    public static void main(String[] args) {
         SpringApplication.run(CharityApplication.class, args);
    }

}
