package za.ac.cput.controller.employee;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.employee.Employee;
import za.ac.cput.service.employee.EmployeeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/managment/employee/")
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    private Optional<Employee> getById(String id){
        return this.employeeService.read(id);
    }

    @PostMapping("save")
    public ResponseEntity<Employee> save(@RequestBody Employee employee){
        log.info(" Save request: {}" , employee);
        Employee save = employeeService.save(employee);
    return ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Employee> read(@PathVariable String id){
        log.info(" Save request: {}" , id);
        Employee employee = getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
        return ResponseEntity.ok(employee);}

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info(" Save request: {}" , id);
        this.employeeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("findAll")
    public ResponseEntity<List<Employee>> findAll()
    {
        List<Employee> employeeList = this.employeeService.findAll();
        return ResponseEntity.ok(employeeList);
    }

}

