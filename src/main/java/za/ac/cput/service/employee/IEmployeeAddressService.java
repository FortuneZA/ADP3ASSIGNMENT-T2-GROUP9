/*
 * IEmployeeAddressService.java
 * Service for the Employee address
 * Author: Mawande Langa (219074054)
 * */
package za.ac.cput.service.employee;

import za.ac.cput.domain.employee.EmployeeAddress;
import za.ac.cput.service.IService;

import java.util.List;

public interface IEmployeeAddressService extends IService<EmployeeAddress, String> {
    List<EmployeeAddress> findAll();
}
