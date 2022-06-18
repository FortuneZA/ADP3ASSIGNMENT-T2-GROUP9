/*
 * IStudentAddressRepository.java
 * Entity for the Student address
 * Author: Mawande Langa (219074054)
 * */
package za.ac.cput.repository.student;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.student.StudentAddress;

import java.util.List;

public interface IStudentAddressRepository extends JpaRepository<StudentAddress,String> {
    List<StudentAddress> findAll();
}
