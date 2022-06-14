package za.ac.cput.service.student;

import za.ac.cput.domain.student.Student;
import za.ac.cput.service.IService;

import java.util.List;

public interface IStudentService extends IService<Student,String> {
    List<Student> findAll();

    //List<Student> findStudentsByCountryId(String countryId);
}
