package za.ac.cput.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.employee.Employee;
import za.ac.cput.repository.employee.IEmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    private final IEmployeeRepository repository;

    @Autowired
    public EmployeeService(IEmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee save(Employee employee) { return this.repository.save(employee);}

    @Override
    public Optional<Employee> read(String s) { return this.repository.findById(s);}

    @Override
    public void delete(Employee employee) { this.repository.delete(employee);}

    @Override
    public List<Employee> findAll() { return this.repository.findAll(); }




}
