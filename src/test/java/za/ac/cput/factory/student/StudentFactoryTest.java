package za.ac.cput.factory.student;

/* StudentFactoryTest.java
Factory test class for Student
Author: Cameron Henry Noemdo (219115443)
Date: 10 June 2022
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.identity.Name;
import za.ac.cput.domain.student.Student;
import za.ac.cput.factory.identity.NameFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentFactoryTest {
    private Student student;
    private final Name name = NameFactory.buildName("John", "Hughes", "Doe");

    @Order(1)
    @Test
    void successCreateStudent() {
        student=StudentFactory.newStudent("21","jhd@gmail.com", name);
        System.out.println(student);
        assertAll(
                ()->assertNotNull(student),
                ()->assertEquals("John",student.getName().getFirstName()),
                ()->assertEquals("jhd@gmail.com",student.getEmail())
        );
    }

    @Order(2)
    @Test
    void failCreateStudent() {
        Exception exception=assertThrows(IllegalArgumentException.class,
                ()->student=StudentFactory.newStudent("","jhd@gmail.com", name)); // missing studentid
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("StudentId"));
    }

    @Order(3)
    @Test
    void testInvalidEmail() {
        Exception exception=assertThrows(IllegalArgumentException.class,
                ()->student=StudentFactory.newStudent("21","jhdgmail.com", name)); // missing @
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("Invalid email"));
    }

    @Order(4)
    @Test
    void testNoEmail() {
        Exception exception=assertThrows(IllegalArgumentException.class,
                ()->student=StudentFactory.newStudent("21","", name)); // missing email
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("Invalid email"));
    }
}