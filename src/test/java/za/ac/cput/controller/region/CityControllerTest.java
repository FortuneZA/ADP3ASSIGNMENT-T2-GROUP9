/* CityControllerTest.java

Author: Devon Daniels. (217299822)
Date: 16 June 2022
*/
package za.ac.cput.controller.region;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.region.City;

import za.ac.cput.factory.region.CityFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CityControllerTest {

    @LocalServerPort
    private int port;
    @Autowired private CityController controller;

    @Autowired private TestRestTemplate restTemplate;
    private City city;

    private final City name = CityFactory.newCity("2022", "Paarl", "Sudan");
    private String baseUrl;



    @BeforeEach
    void setUp() {
        city = CityFactory.newCity("2021", "Parkwood", "USA");

        baseUrl = "http://localhost:" + this.port + "/city";


    }

    @Test
    @Order(1)

    void save() {

        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<City> response = this.restTemplate
                .postForEntity(url, this.city,City.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())

        );
    }

    @Test
    @Order(2)
    void read() {

        String url = baseUrl + "read/" + this.city.getCityId();
        System.out.println(url);
        ResponseEntity<City> response = this.restTemplate.getForEntity(url, City.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())


        );
    }

    @Test
    @Order(3)
    void delete() {
        String url = baseUrl + "delete/" + this.city.getCityId();
        this.restTemplate.delete(url);
    }


    @Test
    @Order(4)
    void findAll() {
        {
            String url = baseUrl + "findAll";
            System.out.println(url);
            ResponseEntity<City[]> response = this.restTemplate.getForEntity(url, City[].class);
            System.out.println(Arrays.asList(response.getBody()));

            assertAll(
                    () -> assertEquals(HttpStatus.OK, response.getStatusCode()),

                    () -> assertFalse(response.getBody().length==0));

        }
    }
}