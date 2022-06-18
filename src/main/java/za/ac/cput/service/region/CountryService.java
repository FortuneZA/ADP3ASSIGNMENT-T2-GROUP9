package za.ac.cput.service.region;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.region.Country;

import za.ac.cput.repository.region.ICountryRepository;
import za.ac.cput.service.region.ICountryService;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService implements ICountryService {

    private final ICountryRepository repository;

    @Autowired
    public CountryService(ICountryRepository repository)
    {
        this.repository=repository;
    }

    @Override
    public Country save(Country country) {
        return this.repository.save(country);
    }

    @Override
    public Optional<Country> read(String s) {
        return this.repository.findById(s);    }

    @Override
    public void delete(Country country) {
        this.repository.delete(country);
    }

    @Override
    public List<Country> readAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String id) {
        Optional<Country> country = read(id);
        country.ifPresent(this::delete);

    }
}