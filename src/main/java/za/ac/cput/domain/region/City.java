/* City.java
Value Object class for City
Author: Devon Daniels -217299822
Date: 16 June 2022
*/
package za.ac.cput.domain.region;

import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Embeddable
@IdClass(City.CityId.class)

public class City implements Serializable {
    @NotNull @Id public String id;
    @NotNull
    public String name;


    @Embedded
    public Country country;

    public Country getCountry() {
        return country;
    }
    protected City() {
    }


    public City(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static class Builder {
        public String id;
        public String name;

        public City.Builder id(String id) {
            this.id = id;
            return this;
        }

        public City.Builder name(String name) {
            this.name = name;
            return this;
        }

        public City.Builder copy(City city) {
            this.id = city.id;
            this.name = city.name;
            return this;
        }

        public City build(){
            return new City(this);
        }
    }

    public static class CityId implements Serializable
    {
        public String id;
        public CityId(String id){this.id=id;}
        protected CityId(){}
        public String getId(){return id;}
    }

    @Override
    public boolean equals(Object o)
    {
        if(this==o) return true;
        if(o==null || getClass()!=o.getClass()) return false;
        City city=(City) o;
        return id.equals(city.id);
    }

    @Override
    public int hashCode(){return Objects.hash(id);}

    @Override
    public String toString()
    {
        return "City{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' + '}';
    }

}

