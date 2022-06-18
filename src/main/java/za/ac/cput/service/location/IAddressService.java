package za.ac.cput.service.location;
import za.ac.cput.service.IService;
import za.ac.cput.domain.location.Address;

import java.util.List;

public interface IAddressService extends  IService<Address ,String>
{
    List<Address> findAll();
}
