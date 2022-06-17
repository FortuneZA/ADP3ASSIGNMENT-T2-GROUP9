/* CityFactoryTest.java

Author: Devon Daniels -217299822
Date: 16 June 2022
*/
package za.ac.cput.factory.region;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.region.City;

import static org.junit.jupiter.api.Assertions.*;

class CityFactoryTest {
    @Test
    public void buildWithSuccess()
    {
        City city=CityFactory
                .build("7975","Paarl");
        System.out.println(city);
        assertNotNull(city);
    }
    @Test
    void buildWithError()
    {
        Exception exception=assertThrows(IllegalArgumentException.class,()-> CityFactory.build(null, "Cape Town"));
        String exceptionMessage=exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("City ID is required!",exceptionMessage);
    }



}
