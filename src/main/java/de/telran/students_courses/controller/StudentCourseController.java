package de.telran.students_courses.controller;

import de.telran.students_courses.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StudentCourseController {

    @Autowired
    private StudentCourseService service;

    @PostMapping("/students/{studentId}/courses/{courseId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void registerStudent(@PathVariable("studentId") Long studentId,
                                @PathVariable("courseId") Long courseId){
        service.registrateStudent(studentId,courseId);
    }
}
