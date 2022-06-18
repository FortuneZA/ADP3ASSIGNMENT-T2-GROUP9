/* CityFactory.java

Author: Devon Daniels. (217299822)
Date: 16 June 2022
*/
package za.ac.cput.factory.region;


import org.springframework.util.StringUtils;
import za.ac.cput.domain.identity.Name;
import za.ac.cput.domain.region.City;


public class CityFactory {
    public static City newCity(String cityId, String cityName, String country) {
        if(StringUtils.isEmpty(cityId))
            throw new IllegalArgumentException("Id is not present");
        if(StringUtils.isEmpty(cityName))
            throw new IllegalArgumentException("Name is not present");

        return new City.Builder().
                setCityId(cityId).
                setCityName(cityName).
                setCountry(country).
                build();
    }
}
