package de.telran.students_courses.service.impl;

import de.telran.students_courses.converters.Converters;
import de.telran.students_courses.dto.reponse.StudentAllResponseDTO;
import de.telran.students_courses.dto.reponse.StudentResponseDTO;
import de.telran.students_courses.dto.request.StudentRequestDTO;
import de.telran.students_courses.entity.Student;
import de.telran.students_courses.repository.StudentRepository;
import de.telran.students_courses.service.CourseService;
import de.telran.students_courses.service.StudentCourseService;
import de.telran.students_courses.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Autowired
    private StudentCourseService studentCourseService;

    @Autowired
    private CourseService courseService;

    @Override
    @Transactional
    public void create(StudentRequestDTO studentDTO) {
        var student = Converters.convertToStudentEntity(studentDTO);
        if (repository.existsByName(student.getName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    String.format("The student with name [%s] already exists! ", student.getName()));
        }
        repository.save(student);
    }

    @Override
    @Transactional
    public StudentResponseDTO getById(Long id) {
        var student = findStudentById(id);
        var courseIds = studentCourseService.getCourseIds(studentCourseService.getAllById(id));
        var courses = courseService.getCoursesByIds(courseIds);

        return StudentResponseDTO
                .builder()
                .name(student.getName())
                .courses(courses)
                .build();
    }

    @Override
    @Transactional
    public List<StudentAllResponseDTO> getAll() {
        return Converters.convertStudentsToAllDTO(repository.findAll());
    }

    private Student findStudentById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("There is no student with id [%s] in database", id)));
    }
}
