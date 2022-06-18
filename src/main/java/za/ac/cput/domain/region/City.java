/* City.java
Value Object class for City
Author: Devon Daniels. (217299822)
Date: 16 June 2022
*/
package za.ac.cput.domain.region;

import com.sun.istack.NotNull;
import za.ac.cput.domain.region.City;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class City implements Serializable {
    @Id
    @NotNull
    private String cityId;
    @NotNull
    private String cityName;
    @Embedded
    @NotNull private String country;

    protected City(){}

    public City(za.ac.cput.domain.region.City.Builder builder) {
        this.cityId = builder.cityId;
        this.cityName = builder.cityName;
        this.country = builder.country;
    }

    public String getCityId() {
        return cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCountry() {
        return country;
    }

    public static class Builder {
        private String cityId;
        private String cityName;
        private String country;

        public za.ac.cput.domain.region.City.Builder setCityId(String cityId) {
            this.cityId = cityId;
            return this;
        }

        public za.ac.cput.domain.region.City.Builder setCityName(String cityName) {
            this.cityName = cityName;
            return this;
        }

        public za.ac.cput.domain.region.City.Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        public za.ac.cput.domain.region.City build() {
            return new za.ac.cput.domain.region.City(this);
        }
    }

    @Override
    public String toString() {
        return "City{" +
                "City ID='" + cityId + '\'' +
                ", City='" + cityName + '\'' +
                ", Country='"+country +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        za.ac.cput.domain.region.City city = (za.ac.cput.domain.region.City) o;
        return cityId.equals(city.cityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityId);
    }
}
