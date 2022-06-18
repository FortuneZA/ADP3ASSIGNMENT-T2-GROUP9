package za.ac.cput.service.region;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.region.City;
import za.ac.cput.repository.region.ICityRepository;
import za.ac.cput.service.region.ICityService;

import java.util.List;
import java.util.Optional;

@Service
public class CityService implements ICityService {

    private final ICityRepository repository;

    @Autowired private CityService(ICityRepository repository) {
        this.repository=repository;
    }
    @Override
    public City save(City city) {
        return this.repository.save(city);
    }

    @Override
    public Optional<City> read(String cityId) {
        return this.repository.findById(cityId);
    }

    @Override
    public void delete(City city) {
        this.repository.delete(city);
    }

    @Override
    public List<City> findAll() {
        return this.repository.findAll();
    }



}







