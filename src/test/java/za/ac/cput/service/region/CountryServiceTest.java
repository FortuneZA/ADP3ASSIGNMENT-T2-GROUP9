package za.ac.cput.service.region;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.region.Country;

import za.ac.cput.factory.region.CountryFactory;
import za.ac.cput.service.region.CountryService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CountryServiceTest {

    private final Country country = CountryFactory.build("ID1", "Japan");

    @Autowired
    private CountryService countryService;

    @Order(1)
    @Test
    void save() {
        Country create = countryService.save(this.country);
        assertEquals(this.country, create);
        System.out.println(create);
    }

    @Order(2)
    @Test
    void read() {
        Optional<Country> view = this.countryService.read(this.country.getCountryId());
        assertAll(
                ()-> assertTrue(view.isPresent()),
                ()-> assertEquals(this.country,view.get())
        );
    }

/*    @Test
    void delete() {
    }*/

    @Order(3)
    @Test
    void readAll() {
        List<Country> countryList = this.countryService.readAll();
        assertEquals(1,countryList.size());
    }

    @Order(4)
    @Test
    void deleteById() {
        countryService.deleteById("ID1");
        List<Country> countryList = this.countryService.readAll();
        System.out.println(countryList);
    }
}