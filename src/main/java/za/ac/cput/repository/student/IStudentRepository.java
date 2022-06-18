package za.ac.cput.repository.student;

/* IStudentRepository.java
Repository interface for Student
Author: Cameron Henry Noemdo (219115443)
Date: 10 June 2022
updated
*/

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.student.Student;

import java.util.List;

public interface IStudentRepository  extends JpaRepository<Student,String> {
    List<Student> findAll();

    //List<Student> findStudentsByCountryId(String countryId);
}
