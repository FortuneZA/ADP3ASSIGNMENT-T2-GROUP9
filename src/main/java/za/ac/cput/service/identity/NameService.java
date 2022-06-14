package za.ac.cput.service.identity;


/*NameService.java
Implementation class for NameService
Mathew Fortuin (219069514)
 */



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.identity.Name;
import za.ac.cput.repository.identity.INameRepository;
import za.ac.cput.service.IService;

import java.util.List;
import java.util.Optional;

@Service
public class NameService implements INameService {

 private final INameRepository repository;

 @Autowired private NameService(INameRepository repository)
 {
     this.repository=repository;
 }

 @Override
    public Name save(Name name)
 {
     return this.repository.save(name);
 }

 @Override
    public Optional<Name> read(String lastName)
 {
     return this.repository.findById(lastName);
 }

 @Override
    public void delete(Name name)
 {
     this.repository.delete(name);
 }
 @Override
 public List<Name> findAll()
 {
     return this.repository.findAll();
 }


}


