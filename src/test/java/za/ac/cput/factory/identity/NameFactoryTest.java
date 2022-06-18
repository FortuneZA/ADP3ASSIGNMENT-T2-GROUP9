package za.ac.cput.factory.identity;

/*
Test cases for NameFactory.java
Mathew Fortuin 219069514
12 June 2022
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


import za.ac.cput.domain.identity.Name;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class NameFactoryTest {

private Name name;
private final Name createName = NameFactory.buildName("Matt","Cole","Fortune");

@Order(1)
@Test
void createNameSuccessfully()
{
    name=createName;
    System.out.println(name);

    assertAll(
            ()->assertNotNull(name.getFirstName()),
            ()->assertEquals("Matt",name.getFirstName()),
            ()->assertNotNull(name.getLastName())

    );
    }

 @Order(2)
 @Test
 void createNameFailure()
 {
     Exception exception = assertThrows(IllegalArgumentException.class,
             ()->name=NameFactory.buildName(null,null,"Fortune"));
     System.out.println(exception.getMessage());
     assertFalse(exception.getMessage().contains("firstName"));


}

@Order(3)
@Test
void testNoFirstName()
{
    Exception exception = assertThrows(IllegalArgumentException.class,
            ()->name=NameFactory.buildName(null,"Cole","Fortune")); //Missing First Name
    System.out.println(exception.getMessage());
    assertTrue(exception.getMessage().contains("First Name is not provided!"));
}


    @Order(4)
    @Test
    void testNoLastName()
    {
        Exception exception = assertThrows(IllegalArgumentException.class,
                ()->name=NameFactory.buildName("Matt","Cole",null)); //Missing Last Name
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("Last Name is not provided!"));
    }


}