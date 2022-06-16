package za.ac.cput.domain.location;
import com.sun.istack.NotNull;
import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.Embeddable;
import javax.persistence.AccessType;


@Embeddable
@Access(AccessType.FIELD)
public class Address implements Serializable {


    @NotNull
    private String unitNumber;
    private String complexName;
    private String streetNumber;
    @NotNull
    private String streetName;
    private int postalCode;
    private String City;
    @SuppressWarnings("unused")
    //Parameterless constructor
    protected Address(){}

    public Address(Builder builder) {
        this.unitNumber = builder.unitNumber;
        this.complexName = builder.complexName;
        this.streetNumber = builder.streetNumber;
        this.streetName = builder.streetName;
        this.postalCode = builder.postalCode;
        this.City = builder.City;

    }

    //Getters

    public String getUnitNumber() {
        return unitNumber;
    }
    public String getComplexName() {
        return complexName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }
    public int getPostalCode() {
        return postalCode;
    }


    public String getCity() {
        return City;
    }


    public static class Builder{
        private String unitNumber;
        private String complexName;
        private String streetNumber;
        private String streetName;
        private int postalCode;
        private String City;



        //Setters
        public Builder setUnitNumber(String unitNumber) {
            this.unitNumber = unitNumber;
            return this;
        }


        public Builder setComplexName(String complexName) {
            this.complexName = complexName;
            return this;
        }



        public Builder setStreetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }



        public Builder setStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }


        public Builder setPostalCode(int postalCode) {
            this.postalCode = postalCode;
            return this;
        }


        public Builder setCity(String city) {
            City = city;
            return this;
        }

        public Address build()
        {
            return new Address(this);
        }
    }

    @Override
    public String toString() {
        return "Address{" +
                "unitNumber='" + unitNumber + '\'' +
                ", complexName='" + complexName + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", postalCode=" + postalCode +
                ", City='" + City + '\'' +
                '}';
    }

    //Object validation

    public boolean verify(Object n)
    {
        if(this==n) return true;
        if(n == null || getClass()!= n.getClass()) return false;
        Address address = (Address) n;
        return unitNumber.equals(address.unitNumber);
    }

}





