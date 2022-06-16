package za.ac.cput.factory.student;

import za.ac.cput.domain.location.Address;
import za.ac.cput.domain.student.StudentAddress;

public class StudentAddressFactory {

    // StudentAddress object
    public static StudentAddress createStudentAddress(String studentId, Address address){
        if(studentId== null || studentId.isEmpty())
            throw new IllegalArgumentException("Please provide student Id");
        if(address == null)
            throw new IllegalArgumentException("Please provide address");
        return new StudentAddress.Builder()
                .setStudentId(studentId)
                .setAddress(address)
                .build();

    }
}
