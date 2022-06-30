package de.telran.students_courses.service;

import de.telran.students_courses.dto.reponse.StudentAllResponseDTO;
import de.telran.students_courses.dto.reponse.StudentResponseDTO;
import de.telran.students_courses.dto.request.StudentRequestDTO;

import java.util.List;

public interface StudentService {

    void create (StudentRequestDTO studentDTO);

    StudentResponseDTO getById(Long id);

    List<StudentAllResponseDTO> getAll();
}
