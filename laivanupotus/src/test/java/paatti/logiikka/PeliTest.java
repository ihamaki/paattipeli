package paatti.logiikka;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PeliTest {

    private Peli peli;

    @Before
    public void setUp() {
        this.peli = new Peli(5);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriToimii() {
        Lauta lauta1 = new Lauta(5);
        Lauta lauta2 = new Lauta(5);
        assertEquals(lauta1, peli.getLauta1());
        assertEquals(lauta2, peli.getLauta2());
    }

    @Test
    public void ammuToimiiRuudulleJossaEiLaivaa() {
        peli.getLauta1().lisaaLaivat();
        peli.ammu(peli.getLauta1(), 2, 2);
        assertEquals(true, peli.getLauta1().getRuudut()[2][2].getAmmuttu());
        assertEquals(false, peli.getLauta1().getRuudut()[2][2].getTuhoutunut());
        assertEquals(2, peli.getLauta1().getLaivat().get(0).getEhjatOsat());
        assertEquals(false, peli.getLauta1().getLaivat().get(0).getTuhoutunut());
    }

    @Test
    public void ammuToimiiKunOsuuLaivaanJaLaivaEiTuhoudu() {
        peli.getLauta1().lisaaLaivat();
        peli.ammu(peli.getLauta1(), 1, 2);
        assertEquals(true, peli.getLauta1().getRuudut()[1][2].getAmmuttu());
        assertEquals(true, peli.getLauta1().getRuudut()[1][2].getTuhoutunut());
        assertEquals(1, peli.getLauta1().getLaivat().get(0).getEhjatOsat());
        assertEquals(false, peli.getLauta1().getLaivat().get(0).getTuhoutunut());
    }

    @Test
    public void ammuToimiiKunOsuuLaivaanJaLaivaTuhoutuu() {
        peli.getLauta1().lisaaLaivat();
        peli.ammu(peli.getLauta1(), 1, 2);
        peli.ammu(peli.getLauta1(), 1, 3);
        assertEquals(true, peli.getLauta1().getRuudut()[1][2].getAmmuttu());
        assertEquals(true, peli.getLauta1().getRuudut()[1][2].getTuhoutunut());
        assertEquals(true, peli.getLauta1().getRuudut()[1][3].getAmmuttu());
        assertEquals(true, peli.getLauta1().getRuudut()[1][3].getTuhoutunut());
        assertEquals(0, peli.getLauta1().getLaivat().get(0).getEhjatOsat());
        assertEquals(true, peli.getLauta1().getLaivat().get(0).getTuhoutunut());
    }

    @Test
    public void onkoHavinnytPalauttaaTrueKunPelaajanKaikkiLaivatTuhottu() {
        peli.getLauta1().lisaaLaivat();
        peli.ammu(peli.getLauta1(), 1, 2);
        peli.ammu(peli.getLauta1(), 1, 3);
        assertEquals(true, peli.onkoHavinnyt(peli.getLauta1()));
    }

    @Test
    public void onkoHavinnytPalauttaaFalseKunLaivojaJaljella() {
        peli.getLauta1().lisaaLaivat();
        peli.ammu(peli.getLauta1(), 1, 2);
        assertEquals(false, peli.onkoHavinnyt(peli.getLauta1()));
    }

    @Test
    public void peliPaattynytKunToinenPelaajaHavinnyt() {
        peli.getLauta1().lisaaLaivat();
        peli.getLauta2().lisaaLaivat();
        peli.ammu(peli.getLauta1(), 1, 2);
        peli.ammu(peli.getLauta1(), 1, 3);
        assertEquals(true, peli.onkoPeliPaattynyt());
    }
    
    @Test
    public void peliEiPaattynytKunMolemmillaLaivoja() {
        peli.getLauta1().lisaaLaivat();
        peli.getLauta2().lisaaLaivat();
        assertEquals(false, peli.onkoPeliPaattynyt());
    }

}
