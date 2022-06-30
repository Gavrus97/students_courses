package de.telran.students_courses.service.impl;

import de.telran.students_courses.converters.Converters;
import de.telran.students_courses.dto.reponse.CourseResponseDTO;
import de.telran.students_courses.dto.reponse.StudentCoursesResponseDTO;
import de.telran.students_courses.dto.request.CourseRequestDTO;
import de.telran.students_courses.entity.Course;
import de.telran.students_courses.repository.CourseRepository;
import de.telran.students_courses.repository.StudentCourseRepository;
import de.telran.students_courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository repository;

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    @Override
    public List<StudentCoursesResponseDTO> getCoursesByIds(List<Long> ids) {
        return
        Converters.convertCoursesToStudentCoursesDTO(
                repository.findCoursesByIdIsIn(ids));
    }

    @Override
    public CourseResponseDTO getById(Long id) {
        var course = getCourseById(id);
        Long countStudents = studentCourseRepository.countAllByCourseId(id);
        return Converters.convertCourseToDTO(course, countStudents);
    }

    private Course getCourseById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("There is no course with id [%s]", id)));
    }

    @Override
    public void create(CourseRequestDTO courseDTO) {
        var course = Converters.convertToEntityCourse(courseDTO);
        try{
            repository.save(course);
        } catch (Exception e){
            System.err.format("Course [%s] already exists", course.getCourseName());
        }
    }
}
