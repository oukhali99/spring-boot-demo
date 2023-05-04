package com.example.demo.student;

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
    // curl -X POST http://localhost:8080/api/v1/student -H "Content-Type: application/json" -d '{ "name":"Oussama", "email":"oussama@hotmail.com", "dateOfBirth":"1995-12-18" }'
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    // curl -X DELETE http://localhost:8080/api/v1/student/1
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    // curl -X PUT "http://localhost:8080/api/v1/student/1?name=test&email=oukhali@hotmail.com"
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam  String name,
            @RequestParam String email
    ) {
        studentService.updateStudent(studentId, name, email);
    }
}
