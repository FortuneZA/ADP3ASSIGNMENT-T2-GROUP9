package za.ac.cput.service.identity;
/*
INameService.java
Domain specific interface for Name
Mathew Fortuin(219069514)
 */

import za.ac.cput.domain.identity.Name;
import za.ac.cput.service.IService;

import java.util.List;

public interface INameService extends IService<Name,String> {

    List<Name> findAll();
}
