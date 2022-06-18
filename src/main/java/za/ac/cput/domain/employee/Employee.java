package za.ac.cput.domain.employee;
/*
        employee.java
        Author: Lefu Kumeke - 218147856
        Date :June 2022
        */

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import com.sun.istack.NotNull;
import za.ac.cput.domain.identity.Name;



@Entity
public class Employee implements Serializable {

    @NotNull
    @Id
    private String staffId;

    @NotNull
    private String email;

    @Embedded
    @NotNull
    private Name name;

    public Employee() {
    }

    public Employee(Builder builder) {
        this.staffId = builder.staffId;
        this.email = builder.email;
        this.name = builder.name;
    }

    public String getStaffId() {
        return staffId;
    }

    public String getEmail() {
        return email;
    }

    public Name getName() {
        return name;
    }

    public static class Builder {
        private String staffId;
        private String email;
        private Name name;


        public Builder setStaffId(String staffId) {
            this.staffId = staffId;
            return this;
        }


    public Builder setEmail(String email) {
        this.email = email;
        return this;
    }

    public Builder setName(Name name) {
        this.name = name;
        return this;
    }
        public Employee build() {
            return new Employee(this);
        }
}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return staffId.equals(employee.staffId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffId);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "staffId='" + staffId + '\'' +
                ", email='" + email + '\'' +
                ", name=" + name +
                '}';
    }

}

