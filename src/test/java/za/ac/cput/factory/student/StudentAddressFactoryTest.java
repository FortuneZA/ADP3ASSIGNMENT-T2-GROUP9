package za.ac.cput.factory.student;


import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.location.Address;
import za.ac.cput.domain.region.City;
import za.ac.cput.domain.student.Student;
import za.ac.cput.domain.student.StudentAddress;
import za.ac.cput.factory.location.AddressFactory;

import static org.junit.jupiter.api.Assertions.*;
class StudentAddressFactoryTest {
    private StudentAddress studentAddress;
    private final Address address = AddressFactory.createAddress("01","Student Junction","109","Voortrekka road",7800);

    @Order(1)
    @Test
    void buildStudentAddressWithSuccess(){
        studentAddress = StudentAddressFactory.createStudentAddress("219074052",address);
        System.out.println(studentAddress);
        assertAll(
                ()->assertNotNull(studentAddress),
                ()->assertEquals("219074052",studentAddress.getStudentId())
        );
    }

    @Order(2)
    @Test
    void buildStudentAddressWithNullId(){
        Exception exception = assertThrows(IllegalArgumentException.class,()->
                studentAddress = StudentAddressFactory.createStudentAddress("",address));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("Please provide student Id",exceptionMessage);

    }

    @Order(3)
    @Test
    void buildStudentAddressWithEmptyId(){
        Exception exception = assertThrows(IllegalArgumentException.class, ()->
                studentAddress = StudentAddressFactory.createStudentAddress(null,address));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("Please provide student Id", exceptionMessage);
    }


}