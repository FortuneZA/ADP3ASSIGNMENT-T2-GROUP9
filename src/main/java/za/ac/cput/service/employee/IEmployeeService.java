package za.ac.cput.service.employee;

import za.ac.cput.domain.employee.Employee;
import za.ac.cput.service.IService;

import java.util.List;

public interface IEmployeeService extends IService<Employee, String> {
    List<Employee> findAll();

    void deleteById(String id);

    List<Employee> findByEmail(String email);

   // List<Employee> findByCityId(String cityId);

}
