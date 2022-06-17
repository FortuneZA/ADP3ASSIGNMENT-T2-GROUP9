package za.ac.cput.factory.employee;


import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.employee.EmployeeAddress;
import za.ac.cput.domain.location.Address;
import za.ac.cput.domain.region.City;
import za.ac.cput.factory.location.AddressFactory;

import static org.junit.jupiter.api.Assertions.*;
class EmployeeAddressFactoryTest {

    private EmployeeAddress employeeAddress;
    private City city;
    private final Address address = AddressFactory.createAddress("05","Spring view","63","Molokwane st",7800);

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
    void buildEmployeeAddressWithNull(){
        Exception exception = assertThrows(IllegalArgumentException.class, ()->
                employeeAddress = EmployeeAddressFactory.createEmployeeAddress(null,address));

        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("Please provide staff Id", exceptionMessage);
    }

    @Order(3)
    @Test
    void buildEmployeeAddressWithEmpty(){

        Exception exception =assertThrows(IllegalArgumentException.class,()->
                employeeAddress = EmployeeAddressFactory.createEmployeeAddress("",address));

        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("Please provide staff Id", exceptionMessage);

    }
}