package za.ac.cput.factory.identity;

/* NameFactory.java
Factory class for Name
Author: Mathew Fortuin (219069514)
Date: 11 June 2022
*/

import org.springframework.util.StringUtils;
import za.ac.cput.domain.identity.Name;

public class NameFactory {

    public static Name buildName(String firstName,String middleName,String lastName)
    {
        if(StringUtils.isEmpty(firstName))
            throw new IllegalArgumentException("First Name is not provided!");
        if(StringUtils.isEmpty(lastName))
            throw new IllegalArgumentException("Last Name is not provided!");

        return new Name.Builder()
                .setFirstName(firstName)
                .setmiddleName(middleName)
                .setlastName(lastName)
                .build();
    }


}
