package za.ac.cput.repository.location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.location.Address;
import za.ac.cput.repository.IRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Address.Builder>
{


    //public Set<Address> getAll();


    //List<Address> find(String unitNumber);

   // Address save(Address address);

   // List<Address> findById(String unitNumber);

   Optional<Address> findById(String unitNumber);
}
