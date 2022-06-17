/* CountryFactory.java

Author: Devon Daniels -217299822
Date: 16 June 2022
*/
package za.ac.cput.factory.region;

import za.ac.cput.domain.region.Country;

public class CountryFactory {
    public static Country build(String countryId, String countryName)
    {
        if(countryId ==null ||countryId.isEmpty() )
            throw new IllegalArgumentException("Country Id is required!");
        if( countryName ==null||countryName.isEmpty() )
            throw new IllegalArgumentException("Name is required!");
        return new Country.Builder().countryId(countryId)
                .countryName(countryName).build();

    }
    public static Country.CountryIdentity buildId(Country country)
    {
        return new Country.CountryIdentity(country.getCountryId());
    }
}