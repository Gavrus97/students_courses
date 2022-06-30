package de.telran.students_courses.controller;

import de.telran.students_courses.dto.reponse.CourseResponseDTO;
import de.telran.students_courses.dto.request.CourseRequestDTO;
import de.telran.students_courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    private CourseService service;

    @PostMapping("/courses")
    @ResponseStatus(HttpStatus.CREATED)
    public void create (@RequestBody CourseRequestDTO courseDTO){
        service.create(courseDTO);
    }

    @GetMapping("/courses/{courseId}")
    public CourseResponseDTO getById(@PathVariable("courseId") Long courseId){
        return service.getById(courseId);
    }
}
