/*ICountryRepository.java

Author: Devon Daniels (217299822)
Date: 16 June 2022
*/
package za.ac.cput.repository.region;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.region.Country;

import java.util.List;

@Repository
public interface ICountryRepository extends JpaRepository<Country,Country.CountryIdentity> {
    List<Country> findAll();
    List<Country> findByCountryId(String countryId);
}