package de.telran.students_courses.dto.reponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CourseResponseDTO {

    private String courseName;

    private Long countStudents;
}
