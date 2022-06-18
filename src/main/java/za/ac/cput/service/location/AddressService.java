package za.ac.cput.service.location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.location.Address;
import za.ac.cput.repository.location.IAddressRepository;
import javax.lang.model.element.Name;
import java.util.List;
import java.util.Optional;
/*
AddressService.java
@Author Themba Khanyile
Student Number: 217238173
Date: 11 June 2022
 */

public class AddressService implements IAddressService
{
    private final IAddressRepository repository;

    @Autowired private AddressService(IAddressRepository repository)
    {
        this.repository=repository;
    }



    //public static AddressService getService() {
   // }

    @Override
    public Address save(Address address)
    {
        return this.repository.save(address);
    }

    @Override
    public Optional<Address> read(String unitNumber)
    {
        return this.repository.findById(unitNumber);
    }


    @Override
    public void delete(Address address)
    {
        this.repository.delete (address);
    }
    @Override
    public List<Address> findAll()
    {
        return this.repository.findAll();
    }

}
