package br.com.alura.school.enrollment;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.alura.school.course.Course;
import br.com.alura.school.user.User;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    
    List<Enrollment> findByUserIdAndCourseId(Long userId, Long courseId);

    Optional<Enrollment> findByUserAndCourse(User user, Course course);
    @Query(value= "SELECT NEW br.com.alura.school.enrollment.EnrollmentReport(e.username, "+ 
    "e.user.email, "+ "COUNT (e.user.email))" + "ORDER BY COUNT (e.user.email) DESC")
    List<EnrollmentReport> enrollReport();
}
