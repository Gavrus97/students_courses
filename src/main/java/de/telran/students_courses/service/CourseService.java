package de.telran.students_courses.service;

import de.telran.students_courses.dto.reponse.CourseResponseDTO;
import de.telran.students_courses.dto.reponse.StudentCoursesResponseDTO;
import de.telran.students_courses.dto.request.CourseRequestDTO;
import java.util.List;

public interface CourseService {

    List<StudentCoursesResponseDTO> getCoursesByIds(List<Long> ids);

    CourseResponseDTO getById(Long id);

    void create (CourseRequestDTO courseDTO);
}
