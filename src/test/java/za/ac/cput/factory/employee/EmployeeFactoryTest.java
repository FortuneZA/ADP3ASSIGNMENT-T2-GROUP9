package za.ac.cput.factory.employee;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.employee.Employee;
import za.ac.cput.domain.identity.Name;
import za.ac.cput.factory.identity.NameFactory;

import static org.junit.jupiter.api.Assertions.*;

class  EmployeeFactoryTest {

    private Employee employee;
    private final Name name = NameFactory.buildName("Lefu", "Aubrey", "Kumeke");

    @Test
    public void createEmployeeWithSuccess(){ // Creating employee successfully

        employee = EmployeeFactory.createEmployee("10223964", "lefukumeke@gmail.com", name);
        System.out.println(employee);
        assertAll(
                ()-> assertNotNull(employee),
                ()-> assertEquals("lefukumeke@gmail.com",employee.getEmail()));
    }

    @Test
    public void createWithError (){ //Creating employee with an error, name is null

        Exception exception = assertThrows(IllegalArgumentException.class, ()->
                EmployeeFactory.createEmployee("10223964", "lefukumeke@gmail.com", null));
        String exceptionMessage =  exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame( "Name is Required", exceptionMessage);

    }
    @Test
    public void employeeWithInvalidEmail (){ // invalid email due to misspelling
        Exception exception=assertThrows(IllegalArgumentException.class, ()->
                EmployeeFactory.createEmployee("10223964", "lefugmail.com", name));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("Invalid email"));

    }

}