/* CountryFactoryTest.java

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
import za.ac.cput.domain.region.Country;
import za.ac.cput.factory.region.CityFactory;
import za.ac.cput.factory.student.StudentFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CountryFactoryTest {
    private Country country;
    private final Country name = CountryFactory.newCountry("1024", "Ghana");

    @Order(1)
    @Test
    void successCreateCountry() {
        country = CountryFactory.newCountry("1024", "Ghana");
        System.out.println(country);
        assertAll(
                () -> assertNotNull(country),
                () -> assertEquals("1024", country.getCountryId()),
                () -> assertEquals("Ghana", country.getCountryName())
        );
    }

    @Order(2)
    @Test
    void failCreateCity() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> country = CountryFactory.newCountry("", "Pretoria"));
        System.out.println(exception.getMessage());
        assertFalse(exception.getMessage().contains("CountryId"));
    }

}