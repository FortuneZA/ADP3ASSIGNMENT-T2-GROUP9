/*
 * EmployeeAddress.java
 * Entity for the Employee address
 * Author: Mawande Langa (219074054)
 * Date: 11 June 2022
 * */
package za.ac.cput.domain.employee;

import com.sun.istack.NotNull;
import za.ac.cput.domain.location.Address;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class EmployeeAddress implements Serializable {
    //Attributes
    @NotNull
    @Id
    private String staffId;
    @Embedded
    @NotNull
    private Address address;

    public EmployeeAddress(){

    }
    //  constructor
    public EmployeeAddress(Builder builder){
        this.staffId = builder.staffId;
        this.address = builder.address;
    }
    //Getters
    public String getStaffId() {
        return staffId;
    }

    public Address getAddress() {
        return address;
    }

    // Using the Builder pattern
    public static class Builder{
        private String staffId;
        private Address address;

        public Builder setStaffId(String staffId) {
            this.staffId = staffId;
            return this;
        }

        public Builder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder copy(EmployeeAddress employeeAddress){
            this.staffId = employeeAddress.staffId;
            this.address = employeeAddress.address;
            return this;
        }

        public EmployeeAddress build(){
            return new EmployeeAddress(this);
        }
    }

    // Checking for object equality
    @Override
    public boolean equals(Object obj){

        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        EmployeeAddress employeeAddress = (EmployeeAddress) obj;
        return staffId.equals(employeeAddress.staffId);
    }
    @Override
    public int hashCode(){
        return Objects.hash(staffId);
    }

    //toString method
    @Override
    public String toString() {
        return "EmployeeAddress{" +
                "staffId='" + staffId + '\'' +
                ", address=" + address +
                '}';
    }

}
