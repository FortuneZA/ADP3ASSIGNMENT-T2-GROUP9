/*ICountryRepository.java

Author: Devon Daniels. (217299822)
Date: 16 June 2022
*/
package za.ac.cput.repository.region;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.region.Country;

import java.util.List;

public interface ICountryRepository  extends JpaRepository<Country,String> {
    List<Country> findAll();


}
