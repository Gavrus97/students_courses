package de.telran.students_courses.dto.reponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class StudentResponseDTO {

    private String name;

    @NonNull
    private List<StudentCoursesResponseDTO> courses;
}
