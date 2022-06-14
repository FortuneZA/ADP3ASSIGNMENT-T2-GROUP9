package za.ac.cput.util;

import org.apache.commons.validator.routines.EmailValidator;

public class GenericHelper {
    public static boolean emailValidation(String email) { // email validator
        if(!EmailValidator.getInstance().isValid(email))
            throw new IllegalArgumentException("Invalid email");
        return EmailValidator.getInstance().isValid(email);
    }
}
