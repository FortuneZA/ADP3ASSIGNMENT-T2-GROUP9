package za.ac.cput.service.identity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.identity.Name;
import za.ac.cput.factory.identity.NameFactory;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class NameServiceTest {

    private Name name,saved;
    private final Name createdName = NameFactory.buildName("Matevis","Cole","Fortune");

   @Autowired
   private NameService service;

    @BeforeEach
    void setUp() {

        this.name = createdName;
        this.saved=service.save(this.name);
    }

    @AfterEach
    void tearDown() {this.service.delete(name);}

    @Test
    void create()
    {
        System.out.println(saved);
        assertAll(
                ()->assertEquals(this.name,saved),
                ()->assertNotNull(saved)
        );
    }

    @Test
    void read()
    {

   Optional<Name> read = this.service.read(saved.getFirstName());
   assertAll(
           ()->assertTrue(read.isPresent()),
           ()->assertEquals(saved,read.get()));
           System.out.println(read);

    }

    @Test
    void delete()
    {
        service.delete(saved);
        List<Name> nameList=service.findAll();
        assertEquals(0,nameList.size());
        System.out.println(nameList);
    }

    @Test
    void findAll()
    {
        Name name1 = NameFactory.buildName("Matevis","Cole","Fortune");
        service.save(name1);
        List<Name> nameList=service.findAll();
        assertEquals(1,nameList.size());
        System.out.println(nameList);
    }
}