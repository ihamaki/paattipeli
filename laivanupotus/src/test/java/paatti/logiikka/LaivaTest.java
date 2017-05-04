package paatti.logiikka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LaivaTest {

    private Laiva laiva;

    @Before
    public void setUp() {
        this.laiva = new Laiva(3);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriToimii() {
        assertEquals(3, laiva.getEhjatOsat());
        assertEquals(false, laiva.getTuhoutunut());
    }

    @Test
    public void ammuVahentaaEhjienOsienMaaraa() {
        laiva.ammu();
        assertEquals(2, laiva.getEhjatOsat());
        assertEquals(false, laiva.getTuhoutunut());
    }

    @Test
    public void laivaTuhoutunutKunEhjiaOsiaNolla() {
        laiva.ammu();
        laiva.ammu();
        laiva.ammu();
        assertEquals(0, laiva.getEhjatOsat());
        assertEquals(true, laiva.getTuhoutunut());
    }

    @Test
    public void equalsToimiiKunSamaLaiva() {
        Laiva toinen = new Laiva(3);
        assertEquals(toinen, laiva);
        laiva.ammu();
        laiva.ammu();
        laiva.ammu();
        toinen.ammu();
        toinen.ammu();
        toinen.ammu();
        assertEquals(toinen, laiva);
    }

    @Test
    public void equalsToimiiKunEriLaiva() {
        Laiva toinen = new Laiva(2);
        assertEquals(false, laiva == toinen);
        laiva.ammu();
        assertEquals(false, laiva == toinen);
    }
}
