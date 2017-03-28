package paatti.logiikka;

import java.util.ArrayList;
import java.util.List;
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
        List<Ruutu> ruudut = new ArrayList<>();
        ruudut.add(new Ruutu(1, 2));
        ruudut.add(new Ruutu(1, 3));
        this.laiva = new Laiva(ruudut);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriToimii() {
        assertEquals(false, laiva.isTuhoutunut());
        assertEquals(new Ruutu(1, 2), laiva.getRuudut().get(0));
        assertEquals(new Ruutu(1, 3), laiva.getRuudut().get(1));
    }
    
    @Test
    public void laivaEhjaKunVainOsaRuuduistaTuhoutunut() {
        laiva.getRuudut().get(0).setTuhoutunut(true);
        laiva.tarkistaOnkoTuhoutunut();
        assertEquals(false, laiva.isTuhoutunut());
    }
    
    @Test
    public void laivaTuhoutunutKunRuudutTuhoutuneet() {
        for (Ruutu ruutu : laiva.getRuudut()) {
            ruutu.setTuhoutunut(true);
        }
        laiva.tarkistaOnkoTuhoutunut();
        assertEquals(true, laiva.isTuhoutunut());
    }
    
    @Test
    public void toStringToimii() {
        assertEquals("[1, 2] [1, 3] tuhoutunut:false", laiva.toString());
    }
    
}
