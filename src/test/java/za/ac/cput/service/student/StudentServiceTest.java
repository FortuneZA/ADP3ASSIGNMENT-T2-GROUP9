package za.ac.cput.service.student;

/* StudentServiceTest.java
Service test class for Student
Author: Cameron Henry Noemdo (219115443)
Date: 12 June 2022
*/

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.identity.Name;
import za.ac.cput.domain.student.Student;
import za.ac.cput.factory.identity.NameFactory;
import za.ac.cput.factory.student.StudentFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class StudentServiceTest {
    private Student student,saved;
    private final Name name= NameFactory.buildName("John","Hughes","Doe");

    @Autowired
    private StudentService service;

    @BeforeEach
    void setUp() {
        this.student= StudentFactory.newStudent("219","jhd@gmail.com", name);
        this.saved=service.save(this.student);
    }

    @AfterEach
    void tearDown() {
        this.service.delete(student);
    }

    @Order(1)
    @Test
    void create() {
        System.out.println(saved);
        assertAll(
                ()->assertEquals(this.student,saved),
                ()->assertNotNull(saved)
        );
    }

    @Order(2)
    @Test
    void read() {
        Optional<Student> read=this.service.read(saved.getStudentId());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertEquals(saved,read.get()));
        System.out.println(read);
    }

    @Order(3)
    @Test
    void delete() {
        service.delete(saved);
        List<Student> studentList=service.findAll();
        assertEquals(0,studentList.size());
        System.out.println(studentList);
    }

    @Order(4)
    @Test
    void findAll() {
        Student student1=StudentFactory.newStudent("233","rory@gmail.com",NameFactory.buildName("Rory","Mark","Marlin"));
        service.save(student1);
        List<Student> studentList=service.findAll();
        assertEquals(2,studentList.size());
        System.out.println(studentList);
    }

//    @Override
//    public List<Student> findStudentsByCountryId(String countryId) {
//        return null;
//    }
}