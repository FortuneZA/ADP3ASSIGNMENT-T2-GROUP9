/* CityFactoryTest.java

Author: Devon Daniels. (217299822)
Date: 16 June 2022
*/
package za.ac.cput.factory.region;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.identity.Name;
import za.ac.cput.domain.region.City;
import za.ac.cput.factory.region.CityFactory;
import za.ac.cput.factory.student.StudentFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CityFactoryTest {
    private City city;
    private final City name = CityFactory.newCity("2612", "Parow", "Belarus");

    @Order(1)
    @Test
    void successCreateCity() {
        city = CityFactory.newCity("7975", "Cape Town", "Japan");
        System.out.println(city);
        assertAll(
                () -> assertNotNull(city),
                () -> assertEquals("7975", city.getCityId()),
                () -> assertEquals("Cape Town", city.getCityName())
        );
    }

    @Order(2)
    @Test
    void failCreateCity() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> city = CityFactory.newCity("", "Pretoria", "Alaska"));
        System.out.println(exception.getMessage());
        assertFalse(exception.getMessage().contains("CityId"));
    }

}

