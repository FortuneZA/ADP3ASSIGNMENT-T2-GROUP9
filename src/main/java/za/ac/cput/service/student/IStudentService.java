package za.ac.cput.service.student;

/* IStudentService.java
Service interface for Student
Author: Cameron Henry Noemdo (219115443)
Date: 12 June 2022
*/

import za.ac.cput.domain.student.Student;
import za.ac.cput.service.IService;

import java.util.List;

public interface IStudentService extends IService<Student,String> {
    List<Student> findAll();

    //List<Student> findStudentsByCountryId(String countryId);
}
