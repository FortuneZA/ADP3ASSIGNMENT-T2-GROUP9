/* CityFactory.java

Author: Devon Daniels. (217299822)
Date: 16 June 2022
*/
package za.ac.cput.factory.region;

import za.ac.cput.domain.region.City;


public class CityFactory {
    public static City build(String id, String name)
    {
        if(id ==null ||id.isEmpty() )
            throw new IllegalArgumentException("City Id is required!");
        if( name ==null||name.isEmpty() )
            throw new IllegalArgumentException("Name is required!");
        return new City.Builder().id(id)
                .name(name).build();

    }
    public static City.CityId buildId(City city)
    {
        return new City.CityId(city.getId());
    }

}

