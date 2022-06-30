package de.telran.students_courses.repository;

import de.telran.students_courses.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findCoursesByIdIsIn(List<Long> ids);
}
