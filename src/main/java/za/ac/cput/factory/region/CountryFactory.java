/* CountryFactory.java

Author: Devon Daniels. (217299822)
Date: 16 June 2022
*/
package za.ac.cput.factory.region;

import org.springframework.util.StringUtils;
import za.ac.cput.domain.identity.Name;
import za.ac.cput.domain.region.Country;


public class CountryFactory {
    public static Country newCountry(String countryId, String countryName) {
        if(StringUtils.isEmpty(countryId))
            throw new IllegalArgumentException("Id is not present");
        if(StringUtils.isEmpty(countryName))
            throw new IllegalArgumentException("Name is not present");

        return new Country.Builder().
                setCountryId(countryId).
                setCountryName(countryName).

                build();
    }
}
