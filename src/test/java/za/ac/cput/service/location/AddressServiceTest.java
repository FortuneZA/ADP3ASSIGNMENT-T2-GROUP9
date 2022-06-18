package za.ac.cput.service.location;
import com.sun.istack.NotNull;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.location.Address;
import za.ac.cput.factory.location.AddressFactory;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
/*
AddressServiceTest.java
@Author Themba Khanyile
Student Number: 217238173
Date: 11 June 2022
 */
@SpringBootTest
class AddressServiceTest
{
    private Address  address;
    private Address.Builder unitNumber;
    private AddressService service;

   @BeforeEach
    void setup(){
        this.address = AddressFactory
                .createAddress("114","QuinMews","244","Brarck Street",7405,"CapeTown");
       //this.unitNumber = AddressFactory.createAddress()
       // this.service = AddressService.getService();
        Address saved = this.service.save(this.address);
        assertAll(
                ()-> assertNotNull(saved),
                ()-> assertEquals(this.address, saved)

    );
    }

    @AfterEach
    void tearDown()
    {
      this.service.delete(this.address);
    }

    @Test
    void save(){
        Address saved = this.service.save(address);
    System.out.println(saved);
        assertAll(
                ()-> assertNotNull(saved),
        ()-> assertEquals(this.address, saved)
        );


    }

   /* @Test
    void read()
    {
        Optional<Address> read = this.service.read();
        System.out.println(read);
        assertAll(
                 ()-> assertTrue(this.isPresent()),
                ()-> assertEquals(this.address, read.get())
        );

    }
*/
    private boolean isPresent() {
        if(address != null);
        return true;
    }

    @Test
    void findById()
    {
        String unitNumber = this.address.getUnitNumber();
        List<Address> addressList =
                this.service.findAll();
        System.out.println(addressList);
        assertSame(1, addressList.size());
    }
}