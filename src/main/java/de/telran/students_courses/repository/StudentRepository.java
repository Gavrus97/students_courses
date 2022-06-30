package de.telran.students_courses.repository;

import de.telran.students_courses.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Boolean existsByName(String name);
}
