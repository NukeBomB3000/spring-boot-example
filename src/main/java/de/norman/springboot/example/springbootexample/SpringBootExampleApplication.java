package de.norman.springboot.example.springbootexample;

import de.norman.springboot.example.springbootexample.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class SpringBootExampleApplication {

    public static void main(String[] args) {
    	SpringApplication.run(SpringBootExampleApplication.class, args);
    }


}
