package paatti.logiikka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LautaTest {
    
    private Lauta lauta;

    public LautaTest() {
    }

    @Before
    public void setUp() {
        this.lauta = new Lauta(5);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriToimii() {
        assertEquals(5, lauta.getKoko());
        assertEquals(true, lauta.getLaivat().isEmpty());
    }
    
    @Test
    public void ruutujenAlustusToimii() {
        for (int i = 0; i < lauta.getKoko(); i++) {
            for (int j = 0; j < lauta.getKoko(); j++) {
                assertEquals(false, lauta.getRuudut()[i][j].isSisaltaaLaivan());
                assertEquals(false, lauta.getRuudut()[i][j].isAmmuttu());
                assertEquals(false, lauta.getRuudut()[i][j].isTuhoutunut());
            }
        }
    }
    
    @Test
    public void laivanLisaysToimiiKunRuutuPelilaudalla() {
        lauta.alustaLaiva(1, 2);
        assertEquals(false, lauta.getLaivat().isEmpty());
        assertEquals(true, lauta.getRuudut()[1][2].isSisaltaaLaivan());
    }
    
    @Test
    public void laivaaEiLisataKunRuutuLaudanUlkopuolella() {
        lauta.alustaLaiva(5, 6);
        assertEquals(true, lauta.getLaivat().isEmpty());
    }
    
}
