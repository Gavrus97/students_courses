package de.telran.students_courses.repository;

import de.telran.students_courses.entity.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {

    List<StudentCourse> findAllByStudentId(Long studentId);

    Long countAllByCourseId(Long courseId);

    Boolean existsByCourseIdAndStudentId(Long courseId, Long studentId);
}
