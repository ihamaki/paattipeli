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
                assertEquals(false, lauta.getRuudut()[i][j].getAmmuttu());
                assertEquals(false, lauta.getRuudut()[i][j].getEstetty());
                assertEquals(null, lauta.getRuudut()[i][j].getLaiva());
            }
        }
    }
    
    @Test
    public void lisaaLaivaMerkkaaViereisetRuudutEstetyiksi() {
        lauta.lisaaLaiva(2, 1, 1, 2);
        assertEquals(true, lauta.getRuudut()[0][2].getEstetty());
        assertEquals(true, lauta.getRuudut()[2][2].getEstetty());
        assertEquals(true, lauta.getRuudut()[0][3].getEstetty());
        assertEquals(true, lauta.getRuudut()[2][3].getEstetty());
        assertEquals(true, lauta.getRuudut()[1][1].getEstetty());
        assertEquals(true, lauta.getRuudut()[1][4].getEstetty());
        lauta.lisaaLaiva(2, -1, 5, 5);
        assertEquals(true, lauta.getRuudut()[5][4].getEstetty());
        assertEquals(true, lauta.getRuudut()[5][6].getEstetty());
        assertEquals(true, lauta.getRuudut()[6][4].getEstetty());
        assertEquals(true, lauta.getRuudut()[6][6].getEstetty());
        assertEquals(true, lauta.getRuudut()[4][5].getEstetty());
        assertEquals(true, lauta.getRuudut()[7][5].getEstetty());
    }

    @Test
    public void lisaaLaivaToimiiKunLaivanOnKelvollinen() {
        assertEquals(true, lauta.lisaaLaiva(2, 1, 1, 2));
        assertEquals(true, lauta.lisaaLaiva(3, -1, 4, 0));
        assertEquals(true, lauta.lisaaLaiva(2, 0, 9, 8));
        assertEquals(new Laiva(2), lauta.getLaivat().get(0));
        assertEquals(new Laiva(2), lauta.getRuudut()[1][2].getLaiva());
        assertEquals(new Laiva(2), lauta.getRuudut()[1][3].getLaiva());
        assertEquals(new Laiva(3), lauta.getLaivat().get(1));
        assertEquals(new Laiva(3), lauta.getRuudut()[4][0].getLaiva());
        assertEquals(new Laiva(3), lauta.getRuudut()[5][0].getLaiva());
        assertEquals(new Laiva(3), lauta.getRuudut()[6][0].getLaiva());
        assertEquals(new Laiva(2), lauta.getRuudut()[9][8].getLaiva());
        assertEquals(new Laiva(2), lauta.getRuudut()[9][9].getLaiva());
    }

    @Test
    public void laivaaEiLisataKunLaivaEiKelvollinen() {
        assertEquals(false, lauta.lisaaLaiva(5, 1, 0, 9));
    }

    @Test
    public void laivaEiKelpaaKunJatkuuLaudanUlkopuolelle() {
        assertEquals(false, lauta.tarkistaLaivanKelpoisuus(2, 1, 10, 0));
        lauta.lisaaLaiva(2, 1, 10, 0);
        assertEquals(true, lauta.getLaivat().isEmpty());
        assertEquals(false, lauta.tarkistaLaivanKelpoisuus(4, -1, 8, 0));
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
    public void laivaEiKelpaaKunLiianLahellaToistaLaivaa() {
        assertEquals(true, lauta.tarkistaLaivanKelpoisuus(2, 1, 1, 2));
        lauta.lisaaLaiva(2, 1, 1, 2);
        assertEquals(false, lauta.tarkistaLaivanKelpoisuus(4, -1, 0, 4));
        lauta.lisaaLaiva(4, -1, 0, 4);
        assertEquals(1, lauta.getLaivat().size());
    }

    @Test
    public void ruudunMerkitseminenEstetyksiToimii() {
        lauta.merkitseEstettyRuutu(-1, 0);
        lauta.merkitseEstettyRuutu(10, 0);
        lauta.merkitseEstettyRuutu(0, -1);
        lauta.merkitseEstettyRuutu(0, 10);
        lauta.merkitseEstettyRuutu(1, 2);
        assertEquals(true, lauta.getRuudut()[1][2].getEstetty());
    }

    @Test
    public void onkoKaikkiLaivatLisattyTarkistusToimii() {
        assertEquals(false, lauta.onkoKaikkiLaivatLisatty());
        lauta.lisaaLaiva(2, 1, 0, 0);
        lauta.lisaaLaiva(2, 1, 2, 0);
        lauta.lisaaLaiva(2, 1, 4, 0);
        lauta.lisaaLaiva(2, 1, 6, 0);
        lauta.lisaaLaiva(2, 1, 8, 0);
        assertEquals(true, lauta.onkoKaikkiLaivatLisatty());
    }
    
    @Test
    public void ammuToimiiKunRuutuLaudalla() {
        lauta.lisaaLaiva(2, 1, 1, 2);
        lauta.ammu(1, 2);
        lauta.ammu(0, 0);
        assertEquals(true, lauta.getRuudut()[1][2].getAmmuttu());
        assertEquals(true, lauta.getRuudut()[0][0].getAmmuttu());
        assertEquals(1, lauta.getLaivat().get(0).getEhjatOsat());
        assertEquals(false, lauta.getLaivat().get(0).getTuhoutunut());
    }

    @Test
    public void ammuToimiiOikeinKunRuutuEiLaudalla() {
        lauta.lisaaLaiva(2, 1, 1, 2);
        lauta.ammu(-2, 0);
        lauta.ammu(10, 0);
        lauta.ammu(0, -2);
        lauta.ammu(0, 10);
        assertEquals(false, lauta.getRuudut()[1][2].getAmmuttu());
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
