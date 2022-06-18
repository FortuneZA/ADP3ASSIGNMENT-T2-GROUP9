/* CountryService.java

Author: Devon Daniels. (217299822)
Date: 16 June 2022
*/
package za.ac.cput.service.region;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.region.Country;
import za.ac.cput.repository.region.ICountryRepository;


import java.util.List;
import java.util.Optional;

@Service
public class CountryService implements ICountryService {

    private final ICountryRepository repository;

    @Autowired private CountryService(ICountryRepository repository) {
        this.repository=repository;
    }
    @Override
    public Country save(Country country) {
        return this.repository.save(country);
    }

    @Override
    public Optional<Country> read(String countryId) {
        return this.repository.findById(countryId);
    }

    @Override
    public void delete(Country country) {
        this.repository.delete(country);
    }

    @Override
    public List<Country> findAll() {
        return this.repository.findAll();
    }



}







