package za.ac.cput.factory.identity;

/* NameFactory.java
Factory class for Name
Author: Mathew Fortuin (219069514)
Date: 10 June 2022
*/

import za.ac.cput.domain.identity.Name;

public class NameFactory {

    public static Name buildName(String firstName,String middleName,String lastName)
    {
        return new Name.Builder()
                .setFirstName(firstName)
                .setmiddleName(middleName)
                .setlastName(lastName)
                .build();
    }


}
