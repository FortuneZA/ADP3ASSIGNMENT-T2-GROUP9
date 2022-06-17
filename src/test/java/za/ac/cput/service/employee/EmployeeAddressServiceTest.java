package za.ac.cput.service.employee;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.employee.EmployeeAddress;
import za.ac.cput.domain.location.Address;
import za.ac.cput.factory.employee.EmployeeAddressFactory;
import za.ac.cput.factory.location.AddressFactory;
import za.ac.cput.school_management_main;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeeAddressServiceTest {
   private final Address address = AddressFactory.createAddress("01","six","09","voot",8000);
   private  EmployeeAddress employeeAddress = EmployeeAddressFactory.createEmployeeAddress("1111",address);

   @Autowired private EmployeeAddressService service;

   @Test
    void save(){
       EmployeeAddress saved = this.service.save(this.employeeAddress);
       System.out.println(saved);
       assertAll(
               ()-> assertNotNull(saved),
               ()-> assertEquals(this.employeeAddress, saved)
       );
   }

   @Test
   void read(){
      EmployeeAddress saved = this.service.save(employeeAddress);
      Optional<EmployeeAddress> read = this.service.read(saved.getStaffId());
      assertAll(
              ()-> assertTrue(read.isPresent()),
              ()->assertEquals(saved,read.get())
      );
      System.out.println(read);

   }

   @Test
   void delete(){
      EmployeeAddress saved = this.service.save(employeeAddress);
      service.delete(saved);
      List<EmployeeAddress> employeeAddresses = this.service.findAll();
      assertEquals(0,employeeAddresses.size());
      System.out.println(employeeAddresses);
   }

   @Test
   void readAll(){
     // EmployeeAddress saved = this.service.save(employeeAddress);
      EmployeeAddress employeeAddress1 = EmployeeAddressFactory.createEmployeeAddress("202220",AddressFactory.createAddress("03","MG","06","Boulavard",8000));
      service.save(employeeAddress1);
      List<EmployeeAddress> employeeAddressList = service.findAll();
      assertEquals(1,employeeAddressList.size());
      System.out.println(employeeAddressList);

   }


}