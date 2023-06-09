package com.example.demo.entities.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }


    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        // curl -X POST http://localhost:8080/api/v1/student -H "Content-Type: application/json" -d '{ "name":"Oussama", "email":"oussama@hotmail.com", "dateOfBirth":"1995-12-18" }'
        studentService.addStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        // curl -X DELETE http://localhost:8080/api/v1/student/1
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam  String name,
            @RequestParam String email
    ) {
        // curl -X PUT "http://localhost:8080/api/v1/student/1?name=test&email=oukhali@hotmail.com"
        studentService.updateStudent(studentId, name, email);
    }
}
