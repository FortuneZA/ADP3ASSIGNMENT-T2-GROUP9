/* Country.java
Value Object class for Country
Author: Devon Daniels (217299822)
Date: 16 June 2022
*/
package za.ac.cput.domain.region;

import com.sun.istack.NotNull;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Embeddable
@IdClass(Country.CountryIdentity.class)
public class Country {
    @NotNull
    @Id public String countryId;
    @NotNull
    public String countryName;

    protected Country(){}
    private Country(Builder builder)
    {
        this.countryName=builder.countryName;
        this.countryId=builder.countryId;
    }

    public String getCountryId() {
        return countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public static class Builder
    {
        public String countryId;
        public String countryName;

        public Builder countryId(String countryId)
        {
            this.countryId =countryId;
            return this;
        }

        public Builder countryName(String countryName)
        {
            this.countryName=countryName;
            return this;
        }

        public Builder copy(Country country)
        {
            this.countryId =country.countryId;
            this.countryName=country.countryName;
            return this;
        }

        public Country build(){
            return new Country(this);
        }
    }

    public static class CountryIdentity implements Serializable
    {
        public String countryId;
        public CountryIdentity(String countryId){this.countryId=countryId;}
        protected CountryIdentity(){}
        public String getCountryId() {
            return countryId;
        }

    }

    @Override
    public boolean equals(Object o)
    {
        if(this==o) return true;
        if(o==null || getClass()!=o.getClass()) return false;
        Country country=(Country) o;
        return countryId.equals(country.countryId);
    }

    @Override
    public int hashCode(){return Objects.hash(countryId);}

    @Override
    public String toString() {
        return "Country{" +
                "countryId='" + countryId + '\'' +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}
