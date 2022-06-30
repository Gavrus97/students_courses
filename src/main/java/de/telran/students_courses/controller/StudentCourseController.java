package de.telran.students_courses.controller;

import de.telran.students_courses.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentCourseController {

    @Autowired
    private StudentCourseService service;

    @PostMapping("/students/{studentId}/courses/{courseId}")
    public void registerStudent(@PathVariable("studentId") Long studentId,
                                @PathVariable("courseId") Long courseId){
        service.registrateStudent(studentId,courseId);
    }
}
