/* Country.java
Value Object class for Country
Author: Devon Daniels. (217299822)
Date: 16 June 2022
*/
package za.ac.cput.domain.region;
import com.sun.istack.NotNull;
import za.ac.cput.domain.region.Country;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Country implements Serializable {
    @Id
    @NotNull
    private String countryId;
    @NotNull
    private String countryName;


    protected Country(){}

    public Country(za.ac.cput.domain.region.Country.Builder builder) {
        this.countryId = builder.countryId;
        this.countryName = builder.countryName;

    }

    public String getCountryId() {
        return countryId;
    }

    public String getCountryName() {
        return countryName;
    }



    public static class Builder {
        private String countryId;
        private String countryName;


        public za.ac.cput.domain.region.Country.Builder setCountryId(String countryId) {
            this.countryId = countryId;
            return this;
        }

        public za.ac.cput.domain.region.Country.Builder setCountryName(String countryName) {
            this.countryName = countryName;
            return this;
        }




        public za.ac.cput.domain.region.Country build() {
            return new za.ac.cput.domain.region.Country(this);
        }
    }

    @Override
    public String toString() {
        return "Country{" +
                "Country ID='" + countryId + '\'' +
                ", Country Name='" + countryName + '\'' +

                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        za.ac.cput.domain.region.Country country = (za.ac.cput.domain.region.Country) o;
        return countryId.equals(country.countryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId);
    }
}
