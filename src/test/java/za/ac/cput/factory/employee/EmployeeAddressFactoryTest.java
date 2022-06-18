/*
 * EmployeeAddressFactoryTest.java
 * FactoryTest for the Employee address
 * Author: Mawande Langa (219074054)
 * */
package za.ac.cput.factory.employee;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.employee.EmployeeAddress;
import za.ac.cput.domain.location.Address;
import za.ac.cput.factory.location.AddressFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeAddressFactoryTest {
    private EmployeeAddress employeeAddress;

    private final Address address = AddressFactory.createAddress("05","Spring view","63","Molokwane st",7800,"Cape Town");

    @Order(1)
    @Test
    void buildEmployeeAddressWithSuccess(){
        employeeAddress = EmployeeAddressFactory.createEmployeeAddress("219074054",address);
        System.out.println(employeeAddress);
        assertAll(
                ()->assertNotNull(employeeAddress),
                ()->assertEquals("219074054",employeeAddress.getStaffId())

        );
    }

    @Order(2)
    @Test
    void buildEmployeeAddressWithNullAddress(){
        Exception exception = assertThrows(IllegalArgumentException.class, ()->
                employeeAddress = EmployeeAddressFactory.createEmployeeAddress("1111",null));

        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("Please provide address", exceptionMessage);
    }

    @Order(3)
    @Test
    void buildEmployeeAddressWithEmptyStaffId(){

        Exception exception =assertThrows(IllegalArgumentException.class,()->
                employeeAddress = EmployeeAddressFactory.createEmployeeAddress("",address));

        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("Please provide staff Id", exceptionMessage);

    }

}