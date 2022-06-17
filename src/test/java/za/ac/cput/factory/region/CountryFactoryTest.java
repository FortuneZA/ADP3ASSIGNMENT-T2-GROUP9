/* CountryFactoryTest.java

Author: Devon Daniels (217299822)
Date: 16 June 2022
*/
package za.ac.cput.factory.region;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.region.Country;

import static org.junit.jupiter.api.Assertions.*;

class CountryFactoryTest {
    @Test
    public void buildWithSuccess()
    {
        Country country=CountryFactory
                .build("16","Namibia");
        System.out.println(country);
        assertNotNull(country);
    }
    @Test
    void buildWithError()
    {
        Exception exception=assertThrows(IllegalArgumentException.class,()-> CountryFactory.build(null, "South Africa"));
        String exceptionMessage=exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("Country ID is required!",exceptionMessage);
    }

}