package paatti.logiikka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RuutuTest {

    private Ruutu ruutu;

    @Before
    public void setUp() {
        this.ruutu = new Ruutu(1, 2);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriToimii() {
        assertEquals(1, ruutu.getX());
        assertEquals(2, ruutu.getY());
        assertEquals(false, ruutu.getAmmuttu());
        assertEquals(false, ruutu.getEstetty());
        assertEquals(null, ruutu.getLaiva());
    }

    @Test
    public void equalsToimiiKunSamaRuutu() {
        Ruutu toinen = new Ruutu(1, 2);
        Laiva laiva = new Laiva(2);
        toinen.setLaiva(laiva);
        toinen.setAmmuttu(true);
        ruutu.setAmmuttu(true);
        ruutu.setLaiva(laiva);
        assertEquals(toinen, ruutu);
    }

    @Test
    public void equalsToimiiKunRuudullaEriSisalto() {
        Ruutu toinen = new Ruutu(1, 2);
        toinen.setAmmuttu(true);
        assertFalse(ruutu == toinen);
    }

    @Test
    public void equalsToimiiKunEriRuutu() {
        Ruutu toinen = new Ruutu(1, 3);
        assertFalse(ruutu == toinen);
    }
}
