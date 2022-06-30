package de.telran.students_courses.controller;

import de.telran.students_courses.dto.reponse.StudentAllResponseDTO;
import de.telran.students_courses.dto.reponse.StudentResponseDTO;
import de.telran.students_courses.dto.request.StudentRequestDTO;
import de.telran.students_courses.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/students")
    public void create(@RequestBody StudentRequestDTO studentDTO){
        service.create(studentDTO);
    }

    @GetMapping("/students")
    public List<StudentAllResponseDTO> getAll(){
        return service.getAll();
    }

    @GetMapping("/students/{studentId}")
    public StudentResponseDTO getById(@PathVariable("studentId") Long studentId){
        return service.getById(studentId);
    }
}
