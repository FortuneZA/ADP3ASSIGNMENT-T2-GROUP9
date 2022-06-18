package za.ac.cput.factory.student;

/* StudentFactory.java
Factory class for Student
Author: Cameron Henry Noemdo (219115443)
Date: 11 June 2022
*/

import org.springframework.util.StringUtils;
import za.ac.cput.domain.identity.Name;
import za.ac.cput.domain.student.Student;
import za.ac.cput.util.GenericHelper;

public class StudentFactory {
    public static Student newStudent(String studentId, String email, Name name) {
        if(StringUtils.isEmpty(studentId))
            throw new IllegalArgumentException("StudentId is not present");
        if(StringUtils.isEmpty(name))
            throw new IllegalArgumentException("Name is not present");
        GenericHelper.emailValidation(email);
        return new Student.Builder().
                setStudentId(studentId).
                setEmail(email).
                setName(name).
                build();
    }
}
