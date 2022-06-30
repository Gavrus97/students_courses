package de.telran.students_courses.service;

import de.telran.students_courses.entity.StudentCourse;

import java.util.List;

public interface StudentCourseService {

    List<StudentCourse> getAllById(Long id);

    List<Long> getCourseIds(List<StudentCourse> studentCourses);

    void registrateStudent(Long studentId, Long courseId);

}
