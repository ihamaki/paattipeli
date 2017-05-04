package paatti.logiikka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PeliTest {

    private Peli peli;

    @Before
    public void setUp() {
        this.peli = new Peli(10);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriToimii() {
        assertEquals(10, peli.getLauta1().getKoko());
        assertEquals(10, peli.getLauta2().getKoko());
        assertEquals(1, peli.getPelattava());
        assertEquals(false, peli.getPeliPaattynyt());
    }

    @Test
    public void laivanLisaysToimiiKunLaivaKelvollinen() {
        assertEquals(true, peli.lisaaLaiva(peli.getLauta1(), 2, 1, 1, 2));
        assertEquals(true, peli.lisaaLaiva(peli.getLauta1(), 4, -1, 5, 5));
    }

    @Test
    public void laivaaEiLisataPeliLaudalleKunLaivaEiKelvollinen() {
        assertEquals(false, peli.lisaaLaiva(peli.getLauta1(), 2, 1, 0, 9));
        assertEquals(false, peli.lisaaLaiva(peli.getLauta1(), 4, -1, 7, 0));
    }

    @Test
    public void onkoHavinnytPalauttaaTrueKunPelaajanKaikkiLaivatTuhottu() {
        lisaaLaivat(peli.getLauta1());
        peli.getLauta1().ammu(1, 2);
        peli.getLauta1().ammu(1, 3);
        assertEquals(true, peli.onkoHavinnyt(peli.getLauta1()));
    }

    @Test
    public void onkoHavinnytPalauttaaFalseKunLaivojaJaljella() {
        lisaaLaivat(peli.getLauta1());
        peli.getLauta1().ammu(1, 2);
        assertEquals(false, peli.onkoHavinnyt(peli.getLauta1()));
    }

    @Test
    public void peliPaattynytKunToinenPelaajaHavinnyt() {
        lisaaLaivat(peli.getLauta1());
        lisaaLaivat(peli.getLauta2());
        peli.getLauta1().ammu(1, 2);
        peli.getLauta1().ammu(1, 3);
        assertEquals(true, peli.onkoPeliPaattynyt());
    }

    @Test
    public void peliEiPaattynytKunMolemmillaLaivoja() {
        lisaaLaivat(peli.getLauta1());
        lisaaLaivat(peli.getLauta2());
        assertEquals(false, peli.onkoPeliPaattynyt());
    }

    @Test
    public void pelattavanLaudanVaihtoToimii() {
        peli.vaihdaPelattava();
        assertEquals(2, peli.getPelattava());
        peli.vaihdaPelattava();
        assertEquals(1, peli.getPelattava());
    }

    public void lisaaLaivat(Lauta lauta) {
        lauta.lisaaLaiva(2, 1, 1, 2);
    }

}
