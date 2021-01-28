package de.norman.springboot.example.springbootexample.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student miriam = new Student(
                    1L,
                    "Miriam",
                    LocalDate.of(2000, JANUARY, 18),
                    "miriam@gmail.com");

            Student alex = new Student(
                    2L,
                    "Alex",
                    LocalDate.of(2002, FEBRUARY, 23),
                    "alex@gmail.com");

            repository.saveAll(
                    List.of(miriam, alex)
            );
        };
    }
}
