package za.ac.cput.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.employee.EmployeeAddress;

import java.util.List;

public interface IEmployeeAddressRepository extends JpaRepository <EmployeeAddress,String>{
    List<EmployeeAddress> findAll();
}
