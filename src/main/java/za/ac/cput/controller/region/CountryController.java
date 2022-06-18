/* CountryController.java

Author: Devon Daniels. (217299822)
Date: 16 June 2022
*/
package za.ac.cput.controller.region;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.service.region.CountryService;
import za.ac.cput.domain.region.Country;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/country")
@Slf4j
public class CountryController {

    private final CountryService countryService;
    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    private Optional<Country> getById(String id){
        return this.countryService.read(id);
    }

    @PostMapping("save")
    public ResponseEntity<Country> save(@RequestBody Country country){
        log.info(" Save request: {}" , country);
        Country save = countryService.save(country);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Country> read(@PathVariable String id){
        log.info(" Save request: {}" , id);
        Country country = getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Country not found"));
        return ResponseEntity.ok(country);}

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(@PathVariable Country id) {
        log.info(" Save request: {}" , id);
        this.countryService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("findAll")
    public ResponseEntity<List<Country>> findAll()
    {
        List<Country> countryList = this.countryService.findAll();
        return ResponseEntity.ok(countryList);
    }

}