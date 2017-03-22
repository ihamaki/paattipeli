package paatti.logiikka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RuutuTest {

    public RuutuTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

     @Test
     public void konstruktoriToimii() {
         Ruutu ruutu = new Ruutu(1, 2);
         assertEquals(1, ruutu.getX());
         assertEquals(2, ruutu.getY());
         assertFalse(ruutu.isSisaltaaLaivan());
         assertFalse(ruutu.isTuhoutunut());
         assertFalse(ruutu.isAmmuttu());
     }
}
