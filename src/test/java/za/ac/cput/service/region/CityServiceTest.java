package za.ac.cput.service.region;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import za.ac.cput.domain.region.City;

import za.ac.cput.factory.region.CityFactory;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class CityServiceTest {
    private City city,saved;
    private final City name= CityFactory.newCity("5432","Joburg","Nimibia");

    @Autowired
    private CityService service;

    @BeforeEach
    void setUp() {
        this.city= CityFactory.newCity("1412","Durban", "China");
        this.saved=service.save(this.city);
    }

    @AfterEach
    void tearDown() {
        this.service.delete(city);
    }

    @Order(1)
    @Test
    void create() {
        System.out.println(saved);
        assertAll(
                ()->assertEquals(this.city,saved),
                ()->assertNotNull(saved)
        );
    }

    @Order(2)
    @Test
    void read() {
        Optional<City> read=this.service.read(saved.getCityId());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertEquals(saved,read.get()));
        System.out.println(read);
    }

    @Order(3)
    @Test
    void delete() {
        service.delete(saved);
        List<City> cityList=service.findAll();
        assertEquals(0,cityList.size());
        System.out.println(cityList);
    }

    @Order(4)
    @Test
    void findAll() {
        City city1=CityFactory.newCity("2427","PE","Congo");
        service.save(city1);
        List<City> cityList=service.findAll();
        assertEquals(2,cityList.size());
        System.out.println(cityList);
    }


}