package com.example.demo.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudents() {
        return List.of(
                new Student(
                        1,
                        "Mariam",
                        2,
                        LocalDate.of(1999, Month.JANUARY, 8),
                        "mariam@hotmail.com"
                )
        );
    }
}
