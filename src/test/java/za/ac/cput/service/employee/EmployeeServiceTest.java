package za.ac.cput.service.employee;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.employee.Employee;
import za.ac.cput.domain.identity.Name;
import za.ac.cput.factory.employee.EmployeeFactory;
import za.ac.cput.factory.identity.NameFactory;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class EmployeeServiceTest {


    private final Name name = NameFactory.buildName("Lefu", "Aubrey", "Kumeke");
    private final Employee employee = EmployeeFactory.createEmployee("10223964", "lefukumeke@gmail.com", name);


    @Autowired
    private IEmployeeService employeeService;

    @Order(1)
    @Test
    void save() {
        Employee saved = this.employeeService.save(this.employee);
        assertEquals(this.employee, saved);
        System.out.println(saved);
    }

    @Order(2)
    @Test
    void read(){
        Employee saved = this.employeeService.save(this.employee);
        Optional<Employee> read = this.employeeService.read(saved.getStaffId());
        assertAll(
                ()-> assertTrue(read.isPresent()),
                ()-> assertEquals(this.employee,read.get())
        );
        System.out.println(read);
    }

    @Order(3)
    @Test
    void delete(){
        Employee saved = this.employeeService.save(this.employee);
        employeeService.delete(saved);
        List<Employee> allEmployees = this.employeeService.findAll();
        assertEquals(0,allEmployees.size());
        System.out.println(allEmployees);
    }

    @Order(4)
    @Test
    void findAll(){
        Employee saved = this.employeeService.save(this.employee);
        employeeService.save(saved);
        List<Employee> allEmployees = this.employeeService.findAll();
        assertEquals(1,allEmployees.size());
        System.out.println(allEmployees);
    }


    @Order(5)
    @Test
    void findByEmail(){
        Employee saved = this.employeeService.save(this.employee);
        employeeService.save(saved);
        this.employeeService.findByEmail("lefukumeke@gmail.com");
        List<Employee> aName = this.employeeService.findByEmail(saved.getName().getFirstName());
        System.out.println(aName );
       // assertSame(1,aName.size());

    }

/*
    @Order(6)
    @Test
    void findByCityId(){

    City Saved =   this.employeeService.save(this.employee);

    }*/
}

