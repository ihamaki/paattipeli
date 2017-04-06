package paatti.logiikka;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LautaTest {

    private Lauta lauta;

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
                assertEquals(false, lauta.getRuudut()[i][j].getAmmuttu());
                assertEquals(false, lauta.getRuudut()[i][j].getTuhoutunut());
                assertNull(lauta.getRuudut()[i][j].getLaiva());
            }
        }
    }

    @Test
    public void ammuToimiiKunRuutuLaudalla() {
        lauta.lisaaLaivat();
        lauta.ammu(1, 2);
        assertEquals(true, lauta.getRuudut()[1][2].getAmmuttu());
        assertEquals(true, lauta.getRuudut()[1][2].getTuhoutunut());
        assertEquals(1, lauta.getLaivat().get(0).getEhjatOsat());
        assertEquals(false, lauta.getLaivat().get(0).getTuhoutunut());
    }

    @Test
    public void ammuToimiiOikeinKunRuutuEiLaudalla() {
        lauta.lisaaLaivat();
        lauta.ammu(-2, 2);
        assertEquals(false, lauta.getRuudut()[1][2].getAmmuttu());
        assertEquals(false, lauta.getRuudut()[1][2].getTuhoutunut());
        assertEquals(2, lauta.getLaivat().get(0).getEhjatOsat());
        assertEquals(false, lauta.getLaivat().get(0).getTuhoutunut());
    }

    @Test
    public void laivatTuhottuKunKaikkiTuhoutuneet() {
        ArrayList<Laiva> laivat = new ArrayList<>();
        laivat.add(new Laiva(1));
        laivat.add(new Laiva(2));
        lauta.setLaivat(laivat);
        lauta.getLaivat().get(0).ammu();
        lauta.getLaivat().get(1).ammu();
        lauta.getLaivat().get(1).ammu();
        assertEquals(true, lauta.kaikkiLaivatTuhottu());
    }

    @Test
    public void laivatEiTuhottuKunVainOsaTuhoutunut() {
        ArrayList<Laiva> laivat = new ArrayList<>();
        laivat.add(new Laiva(1));
        laivat.add(new Laiva(2));
        lauta.setLaivat(laivat);
        lauta.getLaivat().get(0).ammu();
        lauta.getLaivat().get(1).ammu();
        assertEquals(false, lauta.kaikkiLaivatTuhottu());
    }

    @Test
    public void equalsToimiiKunSamaLauta() {
        Lauta toinen = new Lauta(5);
        assertEquals(toinen, lauta);
    }

    @Test
    public void equalsToimiiKunEriLaivatLaudalla() {
        Lauta toinen = new Lauta(5);
        toinen.lisaaLaivat();
        assertFalse(lauta == toinen);
    }

}
