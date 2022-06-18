/*
 * EmployeeAddressServiceTest.java
 * Service test for the Employee address
 * Author: Mawande Langa (219074054)
 * */
package za.ac.cput.service.employee;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.employee.EmployeeAddress;
import za.ac.cput.domain.location.Address;
import za.ac.cput.factory.employee.EmployeeAddressFactory;
import za.ac.cput.factory.location.AddressFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeAddressServiceTest {
    private EmployeeAddress employeeAddress, saved;
    private final Address address = AddressFactory.createAddress("03","Le ruth","01","parow st",8000,"Cape town");

    @Autowired
    private EmployeeAddressService service;

    @BeforeEach
    void setUp(){
        this.employeeAddress = EmployeeAddressFactory.createEmployeeAddress("219074054",address);
        this.saved = service.save(this.employeeAddress);
    }

    @Order(1)
    @Test
    void save(){
        System.out.println(saved);
        assertAll(
                ()->assertNotNull(saved),
                ()->assertEquals(this.employeeAddress,saved)
        );
    }

    @Order(2)
    @Test
    void read(){
        Optional<EmployeeAddress> read= this.service.read(saved.getStaffId());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertEquals(this.employeeAddress,read.get())
        );
        System.out.println(saved);
    }

    @Order(3)
    @Test
    void delete(){
        service.delete(saved);
        List<EmployeeAddress> employeeAddresses = this.service.findAll();
        assertEquals(0,employeeAddresses.size());
        System.out.println(employeeAddresses);
    }

    @Order(4)
    @Test
    void readAll(){
        EmployeeAddress employeeAddress1 = EmployeeAddressFactory.createEmployeeAddress("1234567",AddressFactory.createAddress("03","Le ruth","01","parow st",8000,"Cape town"));
        service.save(employeeAddress1);
        List<EmployeeAddress> employeeAddressList =service.findAll();
        assertEquals(1,employeeAddressList.size());
        System.out.println(employeeAddressList);
    }

}