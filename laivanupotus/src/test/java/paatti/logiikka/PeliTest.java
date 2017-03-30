package paatti.logiikka;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PeliTest {

    private Peli peli;

    public PeliTest() {
    }

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
    public void pelinAlussaLaivatLaudalla() {
        peli.lisaaLaivat(peli.getLauta1(), peli.getLauta2());
        ArrayList<Laiva> laivat = luoLaivat();
        assertEquals(laivat.get(0).toString(), peli.getLauta1().getLaivat().get(0).toString());
        assertEquals(laivat.get(1).toString(), peli.getLauta2().getLaivat().get(0).toString());
    }

    @Test
    public void ammuToimiiRuudulleJossaEiLaivaa() {
        peli.lisaaLaivat(peli.getLauta1(), peli.getLauta2());
        peli.ammu(0, 0, peli.getLauta1());
        peli.getLauta1().kaikkiLaivatTuhottu();
        assertEquals(true, peli.getLauta1().getRuudut()[0][0].isAmmuttu());
        assertEquals(false, peli.getLauta1().getRuudut()[0][0].isSisaltaaLaivan());
        assertEquals(false, peli.getLauta1().getRuudut()[0][0].isTuhoutunut());
    }

    @Test
    public void ammuToimiiKunOsuuLaivaanJaLaivaEiTuhoudu() {
        peli.lisaaLaivat(peli.getLauta1(), peli.getLauta2());
        peli.ammu(1, 2, peli.getLauta1());
        peli.getLauta1().kaikkiLaivatTuhottu();
        assertEquals(true, peli.getLauta1().getRuudut()[1][2].isAmmuttu());
        assertEquals(true, peli.getLauta1().getRuudut()[1][2].isSisaltaaLaivan());
        assertEquals(true, peli.getLauta1().getRuudut()[1][2].isTuhoutunut());
        assertEquals(false, peli.getLauta1().getLaivat().get(0).isTuhoutunut());
    }

    @Test
    public void ammuToimiiKunOsuuLaivaanJaLaivaTuhoutuu() {
        peli.lisaaLaivat(peli.getLauta1(), peli.getLauta2());
        peli.ammu(1, 2, peli.getLauta1());
        peli.ammu(1, 3, peli.getLauta1());
        peli.ammu(1, 4, peli.getLauta1());
        peli.getLauta1().kaikkiLaivatTuhottu();
        assertEquals(true, peli.getLauta1().getLaivat().get(0).isTuhoutunut());
    }

    public ArrayList<Laiva> luoLaivat() {
        ArrayList<Ruutu> laivanRuudut1 = new ArrayList<>();
        ArrayList<Ruutu> laivanRuudut2 = new ArrayList<>();

        laivanRuudut1.add(new Ruutu(1, 2));
        laivanRuudut1.add(new Ruutu(1, 3));
        laivanRuudut1.add(new Ruutu(1, 4));

        laivanRuudut2.add(new Ruutu(2, 2));
        laivanRuudut2.add(new Ruutu(3, 2));
        laivanRuudut2.add(new Ruutu(4, 2));

        for (int i = 0; i < 3; i++) {
            laivanRuudut1.get(i).setSisaltaaLaivan(true);
            laivanRuudut2.get(i).setSisaltaaLaivan(true);
        }

        ArrayList<Laiva> laivat = new ArrayList<>();
        laivat.add(new Laiva(laivanRuudut1));
        laivat.add(new Laiva(laivanRuudut2));

        return laivat;
    }

}
