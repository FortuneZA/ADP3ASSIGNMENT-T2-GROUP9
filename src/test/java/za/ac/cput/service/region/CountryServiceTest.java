package za.ac.cput.service.region;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import za.ac.cput.domain.region.Country;

import za.ac.cput.factory.region.CountryFactory;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class CountryServiceTest {
    private Country country,saved;
    private final Country name= CountryFactory.newCountry("7563","Austria");

    @Autowired
    private CountryService service;

    @BeforeEach
    void setUp() {
        this.country= CountryFactory.newCountry("1413","Peru");
        this.saved=service.save(this.country);
    }

    @AfterEach
    void tearDown() {
        this.service.delete(country);
    }

    @Order(1)
    @Test
    void create() {
        System.out.println(saved);
        assertAll(
                ()->assertEquals(this.country,saved),
                ()->assertNotNull(saved)
        );
    }

    @Order(2)
    @Test
    void read() {
        Optional<Country> read=this.service.read(saved.getCountryId());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertEquals(saved,read.get()));
        System.out.println(read);
    }

    @Order(3)
    @Test
    void delete() {
        service.delete(saved);
        List<Country> countryList=service.findAll();
        assertEquals(0,countryList.size());
        System.out.println(countryList);
    }

    @Order(4)
    @Test
    void findAll() {
        Country country1=CountryFactory.newCountry("2412","Chad");
        service.save(country1);
        List<Country> countryList=service.findAll();
        assertEquals(2,countryList.size());
        System.out.println(countryList);
    }


}