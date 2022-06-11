package za.ac.cput.repository.identity;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.identity.Name;

import java.util.List;

public interface INameRepository extends JpaRepository<Name,String> {

    //SELECT * FROM NAME WHERE lastName = ''

   public List<Name> findbyLastName (String lastName);

    public List<Name> getAll();
}
