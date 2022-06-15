package za.ac.cput.repository.location;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.location.Address;
import za.ac.cput.factory.location.AddressFactory;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class AddressRepositoryTest
{
    private static AddressRepository addressRepository = AddressRepository.getRepository();
    private static Address address = AddressFactory.createAddress("122", "Miller", "12", "River Street",7405,"CapeTown");


    @Test
    void a_create() {
        Address created = addressRepository.create(address);
        assertEquals(created.getUnitNumber(), address.getUnitNumber());
        System.out.println("Created Address: " + created.getUnitNumber() + "\nUnit Number: " + address.getUnitNumber() + "\n"
                + created.getComplexName() + "\nComplex Name: " + address.getComplexName() + "\n"
                + created.getStreetNumber() + "\nStreet Number: " + address.getStreetNumber() + "\n"
                + created.getStreetName() + "\nStreet Name: " + address.getStreetName() + "\n"
                + created.getPostalCode() + "\nPostalCode: " + address.getPostalCode() + "\n"
                + created.getCity() + "\nCity: " + address.getCity() + "\n");
    }

    @Test
    void b_read() {
        //a_create();
        Address read = addressRepository.read(address.getUnitNumber());
        //assertNotNull(read);
        System.out.println("Address Read: " + read + "\n");
    }

    @Test
    void c_update() {
        Address updated = new Address.Builder().copy(address).setUnitNumber("17").build();
        //    assertNotNull(studentRepository.update(updated));
        System.out.println("Updated Address:(" + updated.setUnitNumber("17")+ "): " + updated.setComplexName("Elmar Court") + " " + updated.setStreetNumber("405")
                + updated.setStreetName("Pravin Street") + " "+ updated.setPostalCode(4001) + updated.setCity("Durban"));
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
        System.out.println(addressRepository. getAll() + "\n");
    }


}