package za.ac.cput.repository.location;
import za.ac.cput.domain.location.Address;
import za.ac.cput.repository.IRepository;
import java.util.Set;

public interface IAddressRepository extends IRepository<Address, String>
{
    public Set<Address> getAll();
}
