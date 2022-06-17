package za.ac.cput.service.student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.location.Address;
import za.ac.cput.domain.student.StudentAddress;
import za.ac.cput.factory.location.AddressFactory;
import za.ac.cput.factory.student.StudentAddressFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class StudentAddressServiceTest {
    private final Address address = AddressFactory.createAddress("01","six","09","voot",8000);
    private final StudentAddress studentAddress = StudentAddressFactory.createStudentAddress("219074054",address);

    @Autowired private StudentAddressService service;

@Test
    void save(){
    StudentAddress saved = this.service.save(this.studentAddress);
    System.out.println(saved);
    assertAll(
            ()-> assertNotNull(saved),
            ()-> assertEquals(this.studentAddress, saved)
    );
}
    @Test
    void read() {
        StudentAddress saved = this.service.save(this.studentAddress);
        Optional<StudentAddress> read = this.service.read(saved.getStudentId());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(saved, read.get())
        );
        System.out.println(read);
    }

    @Test
    void delete(){
        StudentAddress saved = this.service.save(this.studentAddress);
        service.delete(saved);
        List<StudentAddress> studentAddresses = this.service.findAll();
        assertEquals(0,studentAddresses.size());
        System.out.println(studentAddresses);
    }

    @Test
    void readAll(){
        StudentAddress studentAddress1 = StudentAddressFactory.createStudentAddress("219074056",AddressFactory.createAddress("03","MG","06","Boulavard",8000));
        service.save(studentAddress1);
        List<StudentAddress> studentAddressList = service.findAll();
        assertEquals(1,studentAddressList.size());
        System.out.println(studentAddressList);

    }



    }

