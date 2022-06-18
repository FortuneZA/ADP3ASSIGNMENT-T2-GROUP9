
/*
 * StudentAddressFactoryTest.java
 * FactoryTest for the Student address
 * Author: Mawande Langa (219074054)
 * */
package za.ac.cput.factory.student;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.location.Address;
import za.ac.cput.domain.region.City;
import za.ac.cput.domain.student.StudentAddress;
import za.ac.cput.factory.location.AddressFactory;
import za.ac.cput.factory.region.CityFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentAddressFactoryTest {
    private StudentAddress studentAddress;
    private final City city = CityFactory.newCity("04","PE","South Africa");
    private final Address address = AddressFactory.createAddress("01","Student Junction","109","Voortrekka road",7800,city);

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
    void buildStudentAddressWithEmptyStudentId(){
        Exception exception = assertThrows(IllegalArgumentException.class,()->
                studentAddress = StudentAddressFactory.createStudentAddress("",address));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("Please provide student Id",exceptionMessage);

    }

    @Order(3)
    @Test
    void buildStudentAddressWithNullAddress(){
        Exception exception = assertThrows(IllegalArgumentException.class, ()->
                studentAddress = StudentAddressFactory.createStudentAddress("219074054",null));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("Please provide address", exceptionMessage);
    }
}
