package za.ac.cput.factory.student;


import org.junit.Test;
import za.ac.cput.domain.location.Address;
import za.ac.cput.domain.region.City;
import za.ac.cput.domain.student.Student;
import za.ac.cput.domain.student.StudentAddress;
import za.ac.cput.factory.location.AddressFactory;

import static org.junit.jupiter.api.Assertions.*;
//@TestMethodOrder(MethodOrder.OrderAnnotation.class)
class StudentAddressFactoryTest {
//    private StudentAddress studentAddress;
//    private City city;
//    private final Address address = AddressFactory.createAddress("01","Student Junction","109","Voortrekka road",7800,city);
//
//    @Order(1)
//    @Test
//    void buildStudentAddressWithSuccess(){
//        studentAddress = StudentAddressFactory.createStudentAddress("219074052",address);
//        System.out.println(studentAddress);
//        assertAll(
//                ()->assertNotNull(studentAddress),
//                ()->assertEquals("219074052",studentAddress.getAddress())
//        );
//    }
//
//    @Oder(2)
//    @Test
//    void buildStudentAddressWithFailure(){
//        Exception exception = assertThrows(IllegalArgumentException.class,()->
//                studentAddress = StudentAddressFactory.createStudentAddress("",address));
//        String exceptionMessage = exception.getMessage();
//        System.out.println(exceptionMessage);
//        assertSame("Please provide student Id",exceptionMessage);
//
//    }
//
//    @Oder(3)
//    @Test
//    void buildStudentAddressWithFailure(){
//        Exception exception = assertThrows(IllegalArgumentException.class, ()->
//                studentAddress = StudentAddressFactory.createStudentAddress(null,address));
//        String exceptionMessage = exception.getMessage();
//        System.out.println(exceptionMessage);
//        assertSame("Please provide student Id", exceptionMessage);
//    }


}