package paatti.logiikka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RuutuTest {

    private Ruutu ruutu;

    public RuutuTest() {
    }

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
        assertFalse(ruutu.isSisaltaaLaivan());
        assertFalse(ruutu.isTuhoutunut());
        assertFalse(ruutu.isAmmuttu());
    }

    @Test
    public void toStringToimii() {
        assertEquals("[1, 2]", ruutu.toString());
    }

    @Test
    public void equalsToimiiKunSamaRuutu() {
        Ruutu toinen = new Ruutu(1, 2);
        toinen.setSisaltaaLaivan(true);
        ruutu.setSisaltaaLaivan(true);
        assertEquals(toinen, ruutu);
    }

    @Test
    public void equalsToimiiKunEriRuutu() {
        Ruutu toinen = new Ruutu(1, 2);
        toinen.setSisaltaaLaivan(true);
        assertFalse(ruutu == toinen);
    }
}
