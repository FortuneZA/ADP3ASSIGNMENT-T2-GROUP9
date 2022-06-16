package za.ac.cput.repository.location;
import za.ac.cput.domain.location.Address;
import za.ac.cput.repository.IRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IAddressRepository extends IRepository<Address, String>
{

    //Address create(Address student);

    //Address read(String unitNumber);

   // Address update(Address address);

   // boolean delete(String unitNumber);

    public Set<Address> getAll();


    List<Address> findAll();

    Address save(Address address);

    Optional<Address> findById(String unitNumber);
}
