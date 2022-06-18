/*
 * IStudentAddressService.java
 * Service for the StudentAddress
 * Author: Mawande Langa (219074054)
 * */
package za.ac.cput.service.student;

import za.ac.cput.domain.student.StudentAddress;
import za.ac.cput.service.IService;

import java.util.List;

public interface IStudentAddressService extends IService<StudentAddress,String> {
    List<StudentAddress> findAll();
}
