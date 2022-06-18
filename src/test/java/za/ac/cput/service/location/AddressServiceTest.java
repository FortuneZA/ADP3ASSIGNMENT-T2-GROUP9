package za.ac.cput.service.location;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.employee.Employee;
import za.ac.cput.domain.location.Address;
import za.ac.cput.domain.region.City;

import za.ac.cput.factory.location.AddressFactory;

import java.util.List;
import java.util.Optional;

import za.ac.cput.service.location.AddressService;
import static org.junit.jupiter.api.Assertions.*;

/*
AddressServiceTest.java
@Author Themba Khanyile
Student Number: 217238173
Date: 11 June 2022
 */


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@SpringBootTest
class AddressServiceTest
{
    private final Address address = AddressFactory.createAddress("114","QuinMews","244","Brarck Street",7405,new City());


    @Autowired
    private IAddressService addressService;

    @Order(1)
    @Test
    void save() {
        Address saved = this.addressService.save(this.address);
        assertEquals(this.address, saved);
        System.out.println(saved);
    }

    @Order(2)
    @Test
    void read(){
        Address saved = this.addressService.save(this.address);
        Optional<Address> read = this.addressService.read(saved.getUnitNumber());
        assertAll(
                ()-> assertTrue(read.isPresent()),
                ()-> assertEquals(this.address,read.get())
        );
        System.out.println(read);
    }

    @Order(3)
    @Test
    void delete(){
        Address saved = this.addressService.save(this.address);
        addressService.delete(saved);
        List<Address> allEmployees = this.addressService.findAll();
        assertEquals(0,allEmployees.size());
        System.out.println(allEmployees);
    }

    @Order(4)
    @Test
    void findAll(){
        Address saved = this.addressService.save(this.address);
        addressService.save(saved);
        List<Address> allEmployees = this.addressService.findAll();
        assertEquals(1,allEmployees.size());
        System.out.println(allEmployees);
    }


}