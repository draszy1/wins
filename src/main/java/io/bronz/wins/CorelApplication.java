package io.bronz.wins;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CorelApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CorelApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("aaaaaa");
    }
}
