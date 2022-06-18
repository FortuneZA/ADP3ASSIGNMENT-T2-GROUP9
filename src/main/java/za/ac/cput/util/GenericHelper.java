package za.ac.cput.util;

import org.apache.commons.validator.routines.EmailValidator;
import za.ac.cput.domain.region.City;
public class GenericHelper {

    public static boolean isNullorEmpty(String s) {
        return (s == null || s.equals("") || s.isEmpty() || s.equalsIgnoreCase("null"));
    }
    public static boolean emailValidation(String email) { // email validator
        if(!EmailValidator.getInstance().isValid(email))
            throw new IllegalArgumentException("Invalid email");
        return EmailValidator.getInstance().isValid(email);
    }

    public static boolean cityisNullorEmpty(City city){
        return city == null;
    }
}
