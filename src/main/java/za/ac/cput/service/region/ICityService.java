/* ICityService.java

Author: Devon Daniels. (217299822)
Date: 16 June 2022
*/
package za.ac.cput.service.region;

import za.ac.cput.domain.region.City;
import za.ac.cput.service.IService;

import java.util.List;

public interface ICityService extends IService<City,String> {
    List<City> findAll();


}
