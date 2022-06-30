package de.telran.students_courses.service.impl;

import de.telran.students_courses.entity.StudentCourse;
import de.telran.students_courses.repository.StudentCourseRepository;
import de.telran.students_courses.service.CourseService;
import de.telran.students_courses.service.StudentCourseService;
import de.telran.students_courses.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {

    @Autowired
    private StudentCourseRepository repository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Override
    public List<Long> getCourseIds(List<StudentCourse> studentCourses) {
        return studentCourses.stream()
                .map(StudentCourse::getCourseId)
                .collect(Collectors.toList());
    }

    @Override
    public void registrateStudent(Long studentId, Long courseId) {
        studentService.getById(studentId);
        courseService.getById(courseId);

        if(repository.existsByCourseIdAndStudentId(courseId, studentId)){
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    String.format("The student with id [%s] already take part in ", studentId) +
                            String.format("the course with id [%s]", courseId));
        }

        var studentCourse =
                StudentCourse
                        .builder()
                        .studentId(studentId)
                        .courseId(courseId)
                        .build();

        repository.save(studentCourse);
    }

    @Override
    public List<StudentCourse> getAllById(Long id) {
        return repository.findAllByStudentId(id);
    }
}
