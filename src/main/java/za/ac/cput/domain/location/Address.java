package za.ac.cput.domain.location;

public class Address {
    public String unitNumber;
    public String complexName;
    public String streetNumber;
    public String streetName;
    public int postalCode;
    public String City;

    private Address(Builder builder) {
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

    public String setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
        return unitNumber;
    }

    public String getComplexName() {
        return complexName;
    }

    public String setComplexName(String complexName) {
        this.complexName = complexName;
        return complexName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    //Setter
    public String setStreetName(String streetName) {
        this.streetName = streetName;
        return streetName;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public int setPostalCode(int postalCode) {
        this.postalCode = postalCode;
        return postalCode;
    }

    public String getCity() {
        return City;
    }

    public String setCity(String city) {
        City = city;
        return city;
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

    // Builder Class
    public static class Builder {
        private String unitNumber;
        private String complexName;
        private String streetNumber;
        private String streetName;
        private int postalCode;
        private String City;

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

        public Address build() {
            return new Address(this);

        }

        public Builder copy(Address address) {
            this.unitNumber = address.unitNumber;
            this.complexName = address.complexName;
            this.streetNumber = address.streetNumber;
            this.streetName = address.streetName;
            this.postalCode = address.postalCode;
            this.City = address.City;
            return this;
        }

    }

}