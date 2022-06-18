/* CityFactory.java

Author: Devon Daniels. (217299822)
Date: 16 June 2022
*/
package za.ac.cput.factory.region;

import za.ac.cput.util.GenericHelper;
import za.ac.cput.domain.region.City;
import za.ac.cput.domain.region.Country;


public class CityFactory {
    public static City build(String id, String name, Country country){

        if(GenericHelper.isNullorEmpty(id)|| GenericHelper.isNullorEmpty(name))
            throw new IllegalArgumentException("id or name is null or empty");

        return new City.Builder().setId(id)
                .setName(name)
                .setCountry(country)
                .build();

    }
}
