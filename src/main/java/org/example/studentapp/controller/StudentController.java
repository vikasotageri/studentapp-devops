package org.example.studentapp.controller;

import org.example.studentapp.entity.Student;
import org.example.studentapp.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return service.save(student);
    }

    @GetMapping
    public List<Student> getStudents() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}