/* City.java
Value Object class for City
Author: Devon Daniels. (217299822)
Date: 16 June 2022
*/
package za.ac.cput.domain.region;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;


@Entity
public class City implements Serializable {
    @NotNull
    @Id
    private String id;
    @NotNull
    private String name;

    @ManyToOne(targetEntity = Country.class, cascade = CascadeType.ALL)
    private Country country;

    public Country getCountry() {
        return country;
    }

    public City() {
    }

    private City(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.country = builder.country;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o)
    {
        if(this==o) return true;
        if(o==null || getClass()!=o.getClass()) return false;
        City city=(City) o;
        return id.equals(city.id) && name.equals(city.name) && country.equals(country);
    }

    @Override
    public int hashCode(){return Objects.hash(id, name, country);}

    @Override
    public String toString()
    {
        return "City{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' + '}';
    }

    public static class Builder {
        private String id;
        private String name;
        private Country country;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        public Builder setCountry(Country country){
            this.country = country;
            return this;
        }

        public Builder copy(City city) {
            this.id = city.id;
            this.name = city.name;
            this.country = city.country;
            return this;
        }

        public City build(){
            return new City(this);
        }
    }

}

