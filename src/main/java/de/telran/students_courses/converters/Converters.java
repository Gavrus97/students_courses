package de.telran.students_courses.converters;

import de.telran.students_courses.dto.reponse.CourseResponseDTO;
import de.telran.students_courses.dto.reponse.StudentAllResponseDTO;
import de.telran.students_courses.dto.reponse.StudentCoursesResponseDTO;
import de.telran.students_courses.dto.reponse.StudentResponseDTO;
import de.telran.students_courses.dto.request.CourseRequestDTO;
import de.telran.students_courses.dto.request.StudentRequestDTO;
import de.telran.students_courses.entity.Course;
import de.telran.students_courses.entity.Student;

import java.util.List;
import java.util.stream.Collectors;

public class Converters {

    public static Student convertToStudentEntity(StudentRequestDTO studentDTO) {
        return Student.builder()
                .name(studentDTO.getName())
                .build();
    }

    public static List<StudentAllResponseDTO> convertStudentsToAllDTO(List<Student> students) {
        return students
                .stream()
                .map(Converters::convertStudentToAllDto)
                .collect(Collectors.toList());
    }

    public static StudentAllResponseDTO convertStudentToAllDto(Student student) {
        return StudentAllResponseDTO
                .builder()
                .name(student.getName())
                .build();
    }

    public static List<StudentCoursesResponseDTO> convertCoursesToStudentCoursesDTO(List<Course> courses) {
        return courses
                .stream()
                .map(x -> StudentCoursesResponseDTO
                        .builder()
                        .courseName(x.getCourseName())
                        .build())
                .collect(Collectors.toList());
    }

    public static CourseResponseDTO convertCourseToDTO(Course course, Long countStudents) {
        return CourseResponseDTO
                .builder()
                .courseName(course.getCourseName())
                .countStudents(countStudents)
                .build();
    }

    public static Course convertToEntityCourse(CourseRequestDTO courseDTO) {
        return Course.builder()
                .courseName(courseDTO.getCourseName())
                .build();
    }
}
