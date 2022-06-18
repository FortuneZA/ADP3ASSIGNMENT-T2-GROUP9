/*
 * EmployeeAddressFactory.java
 * Factory for the Employee address
 * Author: Mawande Langa (219074054)
 * */
package za.ac.cput.factory.employee;

import za.ac.cput.domain.employee.EmployeeAddress;
import za.ac.cput.domain.location.Address;

public class EmployeeAddressFactory {
    // Employee aaddress objects
    public static EmployeeAddress createEmployeeAddress(String staffId, Address address){
        if(staffId == null || staffId.isEmpty())
            throw new IllegalArgumentException("Please provide staff Id");
        if(address == null)
            throw new IllegalArgumentException("Please provide address");
        return new EmployeeAddress.Builder()
                .setStaffId(staffId)
                .setAddress(address)
                .build();

    }
}
