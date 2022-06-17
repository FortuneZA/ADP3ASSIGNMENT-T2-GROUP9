package za.ac.cput.controller.location;

import javassist.bytecode.ExceptionsAttribute;
import jdk.internal.net.http.common.MinimalFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.util.Optional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.location.Address;
import za.ac.cput.service.location.AddressService;

import java.util.Optional;

@RestController
@RequestMapping
public class AddressController
{
 private  final AddressService addressService;

 @Autowired
    public AddressController(AddressService addressService){
     this.addressService = addressService;
 }

 @PostMapping("save")
    public ResponseEntity<Address> save(Address address){
     Address save = addressService.save(address);
             return ResponseEntity.ok(save);

 }

    @GetMapping("read/{Id}")
    public ResponseEntity<Address> read (@PathVariable String unitNumber) {
        Address address = this.addressService.read(unitNumber)
                .orElseThrow( (  new ResponseStatusException(HttpStatus.NOT_FOUND));q 
        return ResponseEntity.ok(address);
    }

        @DeleteMapping ("delete")
        public ResponseEntity<Void> delete (Address address)
        {
            this.addressService.delete(address);
            return ResponseEntity.noContent().build();
        }

    
}
