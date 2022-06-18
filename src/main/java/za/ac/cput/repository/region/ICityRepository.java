/* ICityRepository.java

Author: Devon Daniels. (217299822)
Date: 16 June 2022
*/
package za.ac.cput.repository.region;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.region.City;

import java.util.List;


@Repository
public interface ICityRepository extends JpaRepository<City,String> {

}


