package za.ac.cput.factory.employee;
/*
        Employee Factory
        Author: Lefu Kumeke - 218147856
        Date :June 2022
        */

import org.springframework.util.StringUtils;
import za.ac.cput.domain.employee.Employee;
import za.ac.cput.domain.identity.Name;
import za.ac.cput.util.GenericHelper;


public class EmployeeFactory {

    public static Employee createEmployee(String staffId, String email, Name name) {

        if( staffId == null || staffId.isEmpty() )
            throw new IllegalArgumentException("Staff ID is Required");

        if(name == null  ) //|| name.isEmpty()

            throw new IllegalArgumentException("Name is Required");

        GenericHelper.emailValidation(email);

        return new Employee.Builder().
                setStaffId(staffId).
                setEmail(email).
                setName(name).
                build();
    }
}
