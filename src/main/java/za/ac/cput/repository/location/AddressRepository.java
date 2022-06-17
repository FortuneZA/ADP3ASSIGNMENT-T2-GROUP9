package za.ac.cput.repository.location;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.location.Address;
/*
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.HashSet;
@SpringBootTest
public  class AddressRepository implements IAddressRepository
{
    private static AddressRepository repository = null;
    private Set<Address> addressDB= null;

    private AddressRepository() {
        addressDB = new HashSet<Address>();
    }

    public static AddressRepository getRepository(){
        if(repository == null)
            repository = new AddressRepository();
        return repository;
    }

    @Override
    public Address create(Address address) {
        boolean success = this.addressDB.add(address);
        if(!success)
            return null;

        return address;
    }

    @Override
    public Address read(String unitNumber) {

        for (Address address : this.addressDB) {
            String UnitNumber;
            if (address.getUnitNumber().equalsIgnoreCase(unitNumber))
                return address;
        }

        return null;
    }

    @Override
    public Address update(Address address) {
        Address preUpdate = read(address.getUnitNumber());

        if (preUpdate != null) {
            this.addressDB.remove(preUpdate);
            this.addressDB.add(address);
            return address;
        }

        return null;
    }

    @Override
    public boolean delete(String unitNumber) {
        Address addressToDelete = read(unitNumber);

        if (addressToDelete != null) {
            this.addressDB.remove(addressToDelete);
            return true;
        }
        return false;
    }

    @Override
    public Set<Address> getAll() {
        return addressDB;
    }

    @Override
    public List<Address> findAll() {
        return null;
    }

    @Override
    public Address save(Address address) {
        return null;
    }

    @Override
    public Optional<Address> findById(String unitNumber) {
        return Optional.empty();
    }


}
*/