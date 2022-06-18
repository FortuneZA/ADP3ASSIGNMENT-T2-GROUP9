/*
 * StudentAddress.java
 * Entity for the Student address
 * Author: Mawande Langa (219074054)
 * Date: 11 June 2022
 * */
package za.ac.cput.domain.student;

import com.sun.istack.NotNull;
import za.ac.cput.domain.location.Address;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class StudentAddress implements Serializable {
    //Attributes
    @NotNull
    @Id
    private String studentId;
    @Embedded
    @NotNull
    private Address address;

    public StudentAddress(){

    }
    // constructor
    public StudentAddress(Builder builder){
        this.studentId = builder.studentId;
        this.address = builder.address;
    }

    // Getters
    public String getStudentId() {
        return studentId;
    }

    public Address getAddress() {
        return address;
    }

    // Using the Builder pattern
    public static class Builder{
        private String studentId;
        private Address address;

        public Builder setStudentId(String studentId) {
            this.studentId = studentId;
            return this;
        }

        public Builder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder copy(StudentAddress studentAddress){
            this.studentId = studentAddress.studentId;
            this.address = studentAddress.address;
            return this;
        }

        public StudentAddress build(){
            return new StudentAddress(this);
        }
    }

    // Checking for equality of objects

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass() ) return false;
        StudentAddress studentAddress = (StudentAddress) obj;
        return studentId.equals(studentAddress.studentId);
    }
    @Override
    public int hashCode(){
        return Objects.hash(studentId);
    }

    //toString method
    @Override
    public String toString() {
        return "StudentAddress{" +
                "studentId='" + studentId + '\'' +
                ", address=" + address +
                '}';
    }

}
