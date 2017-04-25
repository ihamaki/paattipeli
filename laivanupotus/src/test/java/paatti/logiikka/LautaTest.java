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
        this.lauta = new Lauta(10);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriToimii() {
        assertEquals(10, lauta.getKoko());
        assertEquals(true, lauta.getLaivat().isEmpty());
    }

    @Test
    public void ruutujenAlustusToimii() {
        for (int i = 0; i < lauta.getKoko(); i++) {
            for (int j = 0; j < lauta.getKoko(); j++) {
                assertFalse(lauta.getRuudut()[i][j].getAmmuttu());
                assertFalse(lauta.getRuudut()[i][j].getTuhoutunut());
                assertNull(lauta.getRuudut()[i][j].getLaiva());
            }
        }
    }

    @Test
    public void lisaaLaivaToimii() {
        lauta.lisaaLaiva(2, 1, 1, 2);
        lauta.lisaaLaiva(3, -1, 4, 0);
        assertEquals(new Laiva(2), lauta.getLaivat().get(0));
        assertEquals(new Laiva(2), lauta.getRuudut()[1][2].getLaiva());
        assertEquals(new Laiva(2), lauta.getRuudut()[1][3].getLaiva());
        assertEquals(new Laiva(3), lauta.getLaivat().get(1));
        assertEquals(new Laiva(3), lauta.getRuudut()[4][0].getLaiva());
        assertEquals(new Laiva(3), lauta.getRuudut()[5][0].getLaiva());
        assertEquals(new Laiva(3), lauta.getRuudut()[6][0].getLaiva());
    }

    @Test
    public void laivaEiKelpaaKunJatkuuLaudanUlkopuolelle() {
        assertEquals(false, lauta.tarkistaLaivanKelpoisuus(2, 1, 10, 0));
        lauta.lisaaLaiva(2, 1, 10, 0);
        assertEquals(true, lauta.getLaivat().isEmpty());
        assertEquals(false, lauta.tarkistaLaivanKelpoisuus(4, 1, 0, 8));
        lauta.lisaaLaiva(4, 1, 0, 8);
        assertEquals(true, lauta.getLaivat().isEmpty());
    }

    @Test
    public void laivaEiKelpaaKunPaallekkainToisenLaivanKanssa() {
        assertEquals(true, lauta.tarkistaLaivanKelpoisuus(2, 1, 1, 2));
        lauta.lisaaLaiva(2, 1, 1, 2);
        assertEquals(false, lauta.tarkistaLaivanKelpoisuus(2, -1, 1, 3));
        lauta.lisaaLaiva(2, -1, 1, 3);
        assertEquals(1, lauta.getLaivat().size());
    }

    @Test
    public void ammuToimiiKunRuutuLaudalla() {
        lauta.lisaaLaiva(2, 1, 1, 2);
        lauta.ammu(1, 2);
        assertEquals(true, lauta.getRuudut()[1][2].getAmmuttu());
        assertEquals(true, lauta.getRuudut()[1][2].getTuhoutunut());
        assertEquals(1, lauta.getLaivat().get(0).getEhjatOsat());
        assertEquals(false, lauta.getLaivat().get(0).getTuhoutunut());
    }

    @Test
    public void ammuToimiiOikeinKunRuutuEiLaudalla() {
        lauta.lisaaLaiva(2, 1, 1, 2);
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
        Lauta toinen = new Lauta(10);
        assertEquals(toinen, lauta);
    }

    @Test
    public void equalsToimiiKunEriLaivatLaudalla() {
        Lauta toinen = new Lauta(10);
        toinen.lisaaLaiva(2, 1, 1, 2);
        assertFalse(lauta == toinen);
    }

}
