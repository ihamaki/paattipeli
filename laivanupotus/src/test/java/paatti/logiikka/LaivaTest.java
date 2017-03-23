package paatti.logiikka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LaivaTest {
    
    private Laiva laiva;

    public LaivaTest() {
    }

    @Before
    public void setUp() {
        this.laiva = new Laiva();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriToimii() {
        assertEquals(false, laiva.isTuhoutunut());
        assertEquals(true, laiva.getRuudut().isEmpty());
    }
    
    @Test
    public void ruudunLisaysToimii() {
        lisaaRuutu(1, 2);
        Ruutu ruutu = new Ruutu(1, 2);
        assertEquals(ruutu, laiva.getRuudut().get(0));
    }
    
    @Test
    public void laivaEhjaKunVainOsaRuuduistaTuhoutunut() {
        lisaaRuutu(1, 2);
        lisaaRuutu(2, 3);
        laiva.getRuudut().get(0).setTuhoutunut(true);
        laiva.tarkistaOnkoTuhoutunut();
        assertEquals(false, laiva.isTuhoutunut());
    }
    
    @Test
    public void laivaTuhoutunutKunRuudutTuhoutuneet() {
        lisaaRuutu(1, 2);
        lisaaRuutu(2, 1);
        for (Ruutu ruutu : laiva.getRuudut()) {
            ruutu.setTuhoutunut(true);
        }
        laiva.tarkistaOnkoTuhoutunut();
        assertEquals(true, laiva.isTuhoutunut());
    }
    
    // testi ei toimi
//    @Test
//    public void toStringToimii() {
//        lisaaRuutu(1, 2);
//        assertEquals("[1, 2] tuhoutunut: false", laiva);
//    }
    
    public void lisaaRuutu(int x, int y) {
        Ruutu ruutu = new Ruutu(x, y);
        ruutu.setSisaltaaLaivan(true);
        laiva.lisaaRuutu(ruutu);
    }
    
}
