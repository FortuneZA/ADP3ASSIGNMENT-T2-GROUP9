package za.ac.cput.factory.location;
import za.ac.cput.domain.location.Address;
//import za.ac.cput.Util.GenericHelper;

public class AddressFactory
{
    public static Address createAddress(String unitNumber,String complexName, String streetNumber, String streetName, int postalCode, String City)
    {
        if(unitNumber.equals("") || unitNumber == null)
            return null;
        if(complexName.equals("") || complexName == null)
            return null;


        return new Address.Builder().setUnitNumber(unitNumber)

         .setComplexName(complexName)
         .setStreetNumber (streetNumber)
         .setStreetName (streetName)
         .setPostalCode (postalCode)
                .setCity (City)
         .build();
    }

}
