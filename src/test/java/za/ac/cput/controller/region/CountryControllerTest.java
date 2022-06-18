/* CountryControllerTest.java

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
import za.ac.cput.domain.region.Country;

import za.ac.cput.factory.region.CountryFactory;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CountryControllerTest {

    @LocalServerPort
    private int port;
    @Autowired private CountryController controller;

    @Autowired private TestRestTemplate restTemplate;
    private Country country;

    private final Country  name = CountryFactory.newCountry("1512", "Virginia");
    private String baseUrl;



    @BeforeEach
    void setUp() {
        country = CountryFactory.newCountry("1022", "Kansas");

        baseUrl = "http://localhost:" + this.port + "/country";


    }

    @Test
    @Order(1)

    void save() {

        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Country> response = this.restTemplate
                .postForEntity(url, this.country,Country.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())

        );
    }

    @Test
    @Order(2)
    void read() {

        String url = baseUrl + "read/" + this.country.getCountryId();
        System.out.println(url);
        ResponseEntity<Country> response = this.restTemplate.getForEntity(url, Country.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())


        );
    }

    @Test
    @Order(3)
    void delete() {
        String url = baseUrl + "delete/" + this.country.getCountryId();
        this.restTemplate.delete(url);
    }


    @Test
    @Order(4)
    void findAll() {
        {
            String url = baseUrl + "findAll";
            System.out.println(url);
            ResponseEntity<Country[]> response = this.restTemplate.getForEntity(url, Country[].class);
            System.out.println(Arrays.asList(response.getBody()));

            assertAll(
                    () -> assertEquals(HttpStatus.OK, response.getStatusCode()),

                    () -> assertFalse(response.getBody().length==0));

        }
    }
}