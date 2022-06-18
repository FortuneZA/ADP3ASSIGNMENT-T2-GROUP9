package za.ac.cput.controller.employee;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.employee.Employee;
import za.ac.cput.domain.identity.Name;
import za.ac.cput.factory.employee.EmployeeFactory;
import za.ac.cput.factory.identity.NameFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeControllerTest {

    @LocalServerPort
    private int port;
    @Autowired private EmployeeController controller;

    @Autowired private TestRestTemplate restTemplate;
    private Employee employee;

    private final Name name = NameFactory.buildName("Lefu", "Aubrey", "Kumeke");
    private String baseUrl;



    @BeforeEach
    void setUp() {
        employee = EmployeeFactory.createEmployee("10223964", "lefukumeke@gmail.com", name);

        baseUrl = "http://localhost:" + this.port + "/managment/employee/";


    }

    @Test
    @Order(1)

    void save() {

        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Employee> response = this.restTemplate
                .postForEntity(url, this.employee,Employee.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())

        );
    }

    @Test
    @Order(2)
    void read() {

        String url = baseUrl + "read/" + this.employee.getStaffId();
        System.out.println(url);
        ResponseEntity<Employee> response = this.restTemplate.getForEntity(url, Employee.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())


        );
    }

    @Test
    @Order(3)
    void delete() {
        String url = baseUrl + "delete/" + this.employee.getStaffId();
        this.restTemplate.delete(url);
    }


    @Test
    @Order(4)
    void findAll() {
        {
            String url = baseUrl + "findAll";
            System.out.println(url);
            ResponseEntity<Employee[]> response = this.restTemplate.getForEntity(url, Employee[].class);
            System.out.println(Arrays.asList(response.getBody()));

            assertAll(
                    () -> assertEquals(HttpStatus.OK, response.getStatusCode()),

                    () -> assertFalse(response.getBody().length==0));

        }
}
}