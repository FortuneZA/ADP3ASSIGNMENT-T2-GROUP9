package za.ac.cput.service.region;
import za.ac.cput.domain.region.Country;
import za.ac.cput.service.IService;

import java.util.List;

public interface ICountryService extends IService<Country,String> {
    List<Country> readAll();
    void deleteById(String id);
}