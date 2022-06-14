package za.ac.cput.repository.location;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.location.Address;
import za.ac.cput.factory.location.AddressFactory;

import static org.junit.jupiter.api.Assertions.*;


class AddressRepositoryTest
{
    private static AddressRepository addressRepository = AddressRepository.getRepository();
    private static Address address = AddressFactory.createAddress("17", "Miller", "244", "VoorTrekker Street",7405,"CapeTown");
    @Test
    void a_create() {
        Address created = addressRepository.create(address);
        assertEquals(created.getUnitNumber(), address.getUnitNumber());
        System.out.println("Created ID: " + created.getUnitNumber() + "\nUnit Number: " + address.getUnitNumber() + "\n");
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
        System.out.println("Updated (" + updated.getStudentId() + "): " + updated.getFirstName() + " " + updated.getLastName()
                + updated.getStudentEmail() + " "+ updated.getFirstName() + updated.getCourseID()
                + " " + " = Student: (" + student.getStudentId() + "): " + student.getFirstName() + " " + student.getLastName()
                + student.getStudentEmail() + " "  + student.getCourseID());
    }

    @Test
    void e_delete() {

        boolean deleted = studentRepository.delete(student.getStudentId());
        assertTrue(deleted);
        System.out.println("Deleted: " + deleted);
        d_getAll();

    }

    @Test
    void d_getAll(){
        System.out.println(studentRepository. getAll() + "\n");
    }
}