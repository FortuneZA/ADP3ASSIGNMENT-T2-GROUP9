/* CountryFactory.java

Author: Devon Daniels. (217299822)
Date: 16 June 2022
*/
package za.ac.cput.factory.region;

import za.ac.cput.util.GenericHelper;
import za.ac.cput.domain.region.Country;

public class CountryFactory {

    public static Country build(String countryId, String countryName) {

        if(GenericHelper.isNullorEmpty(countryId)|| GenericHelper.isNullorEmpty(countryName))
            throw new IllegalArgumentException("countryid or countryName is null or empty");

        return new Country.Builder().countryId(countryId)
                .countryName(countryName)
                .build();
    }

}