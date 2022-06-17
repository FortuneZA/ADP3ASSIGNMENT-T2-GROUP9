package za.ac.cput.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.employee.EmployeeAddress;
import za.ac.cput.repository.employee.IEmployeeAddressRepository;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeAddressService implements IEmployeeAddressService{
    private final IEmployeeAddressRepository repository;

    @Autowired public EmployeeAddressService(IEmployeeAddressRepository repository){
        this.repository = repository;
    }
    @Override
    public EmployeeAddress save(EmployeeAddress employeeAddress) {
        return this.repository.save(employeeAddress);
    }

    @Override
    public Optional<EmployeeAddress> read(String staffId) {
        return this.repository.findById(staffId);
    }

    @Override
    public void delete(EmployeeAddress employeeAddress) {
        this.repository.delete(employeeAddress);

    }

    @Override
    public List<EmployeeAddress> findAll() {
        return this.repository.findAll();
    }
}
