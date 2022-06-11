package za.ac.cput.repository.student;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.student.Student;

import java.util.List;

public interface IStudentRepository  extends JpaRepository<Student,String> {
    List<Student> findAll();

    //List<Student> findStudentsByCountryId(String countryId);
}
