/* CityController.java

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
import za.ac.cput.service.region.CityService;
import za.ac.cput.domain.region.City;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/city")
@Slf4j
public class CityController {

    private final CityService cityService;
    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    private Optional<City> getById(String id){
        return this.cityService.read(id);
    }

    @PostMapping("save")
    public ResponseEntity<City> save(@RequestBody City city){
        log.info(" Save request: {}" , city);
        City save = cityService.save(city);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<City> read(@PathVariable String id){
        log.info(" Save request: {}" , id);
        City city = getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "City not found"));
        return ResponseEntity.ok(city);}

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(@PathVariable City id) {
        log.info(" Save request: {}" , id);
        this.cityService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("findAll")
    public ResponseEntity<List<City>> findAll()
    {
        List<City> cityList = this.cityService.findAll();
        return ResponseEntity.ok(cityList);
    }

}