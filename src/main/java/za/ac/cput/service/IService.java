package za.ac.cput.service;
//IService.java
//Generic Interface for Service layer
//Mathew Fortuin (219069514)


import java.util.List;
import java.util.Optional;

public interface IService <T,ID> {

    T save(T t);

    List<T> readOne(ID id);
    List<T> readAll(ID id);

    void delete(ID id);
}