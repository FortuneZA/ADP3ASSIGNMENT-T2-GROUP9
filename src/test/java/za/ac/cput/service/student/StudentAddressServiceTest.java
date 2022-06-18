/*
 * StudentAddressServiceTest.java
 * Service test for the Student address
 * Author: Mawande Langa (219074054)
 * */
package za.ac.cput.service.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.location.Address;
import za.ac.cput.domain.student.StudentAddress;
import za.ac.cput.factory.location.AddressFactory;
import za.ac.cput.factory.student.StudentAddressFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentAddressServiceTest {
    private StudentAddress studentAddress, saved;
    private final Address address = AddressFactory.createAddress("03","Le ruth","01","parow st",8000,"Cape town");

    @Autowired
    private StudentAddressService service;

    @BeforeEach
    void setUp(){
        this.studentAddress = StudentAddressFactory.createStudentAddress("19074054",address);
        this.saved = service.save(this.studentAddress);
    }

    @Order(1)
    @Test
    void save(){
        System.out.println(saved);
        assertAll(
                ()->assertNotNull(saved),
                ()->assertEquals(this.studentAddress,saved)
        );
    }

    @Order(2)
    @Test
    void read(){
        Optional<StudentAddress> read = this.service.read(saved.getStudentId());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertEquals(this.studentAddress,read.get())
        );
        System.out.println(read);
    }

    @Order(3)
    @Test
    void delete(){
        service.delete(saved);
        List<StudentAddress> studentAddresses = this.service.findAll();
        assertEquals(0,studentAddresses.size());
        System.out.println(studentAddresses);
    }

    @Order(4)
    @Test
    void readAll(){
        StudentAddress studentAddress1 = StudentAddressFactory.createStudentAddress("219074056",AddressFactory.createAddress("03","MG","06","Boulavard",8000,"Cape Town"));
        service.save(studentAddress1);
        List<StudentAddress> studentAddressList = service.findAll();
        assertEquals(1,studentAddressList.size());
        System.out.println(studentAddressList);
    }

}