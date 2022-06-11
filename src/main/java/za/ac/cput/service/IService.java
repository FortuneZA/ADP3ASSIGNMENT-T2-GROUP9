package za.ac.cput.service;
//IService.java
//Generic Interface for Service layer
//Mathew Fortuin (219069514)


import java.util.Optional;

public interface IService <T,ID> {

    T create(T t);

    T read(ID id);

    T update(T t);

    void delete(ID id);
}