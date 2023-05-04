package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student student1 = new Student(
                    "Oussama",
                    21,
                    LocalDate.EPOCH,
                    "oussama@hotmail.com"
            );


            Student student2 = new Student(
                    "Oussama2",
                    21,
                    LocalDate.EPOCH,
                    "oussama@hotmail.com"
            );

            studentRepository.saveAll(List.of(student1, student2));
        };
    }
}
