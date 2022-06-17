package za.ac.cput.repository.location;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.location.Address;
import za.ac.cput.factory.location.AddressFactory;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/*
@TestMethodOrder(MethodOrderer.MethodName.class)
class AddressRepositoryTest
{
    private static AddressRepository addressRepository = AddressRepository.getRepository();
    private static Address address = AddressFactory.createAddress("122", "Miller", "12", "River Street",7405,"CapeTown");


    @Test
    void save()
    {
Address saved = this.addressRepository.save(this.address);
        System.out.println(saved);
        assertNotNull(saved);
        assertSame(this.address, saved);
    }
    @Test
    void a_create() {
        Address created = addressRepository.create(address);
        assertEquals(created.getUnitNumber(), address.getUnitNumber());
        System.out.println("Created Address: " +"\nUnit Number: " + created.getUnitNumber() + "Complex Name: " + created.getComplexName()   + "Street Number: " + created.getStreetNumber()   + "Street Name: "  + created.getStreetName()   + "PostalCode: "+ created.getPostalCode() + "City: "+ created.getCity()  + "\n");
    }

    @Test
    void b_read() {
        Optional<Address> read = Optional.ofNullable(this.addressRepository.read(this.address.getUnitNumber()));
        assertAll(

        );
        //a_create();

        //Address read = addressRepository.read(address.getUnitNumber());
        //assertNotNull(read);
       // System.out.println("Address Read: " + read + "\n");
    }

    @Test
    void c_update() {
        Address updated = new Address.Builder().setUnitNumber("15")
                .setComplexName("Elmar Court")
                .setStreetNumber("405")
                .setStreetName("Pravin Street")
                .setPostalCode(4001)
                .setCity("Durban")
                .build();
        assertNotNull(addressRepository.update(updated));
        System.out.println("updated" + updated);
                //(address).setUnitNumber("17").build();
        //    assertNotNull(studentRepository.update(updated));
        //System.out.println("Updated Address:(" + updated.setUnitNumber("17")+ "): " + updated.setComplexName("Elmar Court") + " " + updated.setStreetNumber("405")
               // + updated.setStreetName("Pravin Street") + " "+ updated.setPostalCode(4001) + updated.setCity("Durban"));
                //+ " " + " = Student: (" + address.getUnitNumber() + "): " + address.getComplexName() + " " + address.getStreetNumber()
                //+ address.getStreetName() + " "  + address.getPostalCode() + " " + address.getCity());
    }

    @Test
    void e_delete() {

        boolean deleted = addressRepository.delete(address.getUnitNumber());
        assertTrue(deleted);
        System.out.println("Deleted: " + deleted);
        d_getAll();

    }

    @Test
    void d_getAll(){
        System.out.println("Show All:" + addressRepository. getAll() + "\n");
    }


}

 */