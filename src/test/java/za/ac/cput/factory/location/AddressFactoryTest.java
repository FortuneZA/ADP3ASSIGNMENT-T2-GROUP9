package za.ac.cput.factory.location;

//import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.location.Address;
import za.ac.cput.domain.region.City;

 import java.time.Duration;
class AddressFactoryTest
{
    private String address1;
    private String address2;

    public void createAddress() {
        Address address1 = AddressFactory.createAddress("12", "Pearls", "159", "Ghandi Road",4310,"Durban");
        Address address2 = AddressFactory.createAddress("105","Sunningdale","256","Hannover Street",8001,"CapeTown");

        System.out.println(address1);
        System.out.println(address2);

    }

    @BeforeEach
    void setUp() {
        Address address1 = AddressFactory.createAddress("12", "Pearls", "159", "Ghandi Road",4310,"Durban");
        Address address2 = AddressFactory.createAddress("105","Sunningdale","256","Hannover Street",8001,"CapeTown");

    }

    @Test
    void testEquality() {
        assertEquals(address1, address2);

    }

    @Test
    void testIdentity() {

        assertSame(address1, address2);

    }

    @Test
    void testTimeouts() {
        assertTimeout(Duration.ofMillis(2000), () -> {
            Thread.sleep(1000);
        });
    }

    @Disabled
    @Test
    void disableTest() {
        assertEquals(address1, address2);

    }
}