package za.ac.cput.repository.employee;

/*
        IEmployeeRepository .java
        Author: Lefu Kumeke - 218147856
        Date :June 2022
        */

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.employee.Employee;
import java.util.List;

public interface IEmployeeRepository   extends JpaRepository<Employee, String> {
    List<Employee> findAll();

}
