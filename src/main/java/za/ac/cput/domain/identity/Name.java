package za.ac.cput.domain.identity;




import javax.persistence.Embeddable;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


/* Name.java
Entity class for Name
Author: Mathew Fortuin (219069514)
Date: 10 June 2022
*/
@Embeddable
public class Name implements Serializable {

   @Id
   @NotNull private String firstName;
    private String middleName;
    @NotNull private String lastName;;

    //Parameterless constructor
    protected Name(){}

    public Name(Builder builder) {
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;
    }

    //Getters
    public String getFirstName(){return firstName;}

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }


    public static class Builder{
        private String firstName;
        private String middleName;
        private String lastName;



        //Setters
        public Builder setFirstName(String firstName) {
            this.firstName=firstName;
            return this;
        }

        public Builder setmiddleName(String middleName) {
            this.middleName=middleName;
            return this;
        }

        public Builder setlastName(String lastName) {
            this.lastName=lastName;
            return this;
        }
        public Name build()
        {
            return new Name(this);
        }
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
    //Object validation

    public boolean verify(Object n)
    {
        if(this==n) return true;
        if(n == null || getClass()!= n.getClass()) return false;
        Name name = (Name) n;
        return firstName.equals(name.firstName);
    }

}
