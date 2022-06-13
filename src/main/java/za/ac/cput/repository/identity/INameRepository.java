package za.ac.cput.repository.identity;

/* INameRepository.java
Repository interface for Name
Author: Mathew Fortuin (219069514)
Date: 11 June 2022
*/



import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.identity.Name;

import javax.validation.constraints.Null;
import java.util.List;

public interface INameRepository extends JpaRepository<Name, Null> {

    //SELECT * FROM NAME WHERE lastName = ''

   List<Name> findbyLastName (String lastName);

   List<Name> findAll();
}
