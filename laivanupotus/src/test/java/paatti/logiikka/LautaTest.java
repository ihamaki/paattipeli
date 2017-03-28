package paatti.logiikka;

import java.util.ArrayList;
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
    public void laivatEiTuhottuKunVainOsaTuhottu() {
        ArrayList<Ruutu> laivanRuudut = luoListaRuuduista();
        lauta.alustaLaiva(laivanRuudut);
        lauta.getLaivat().get(0).getRuudut().get(0).setAmmuttu(true);
        lauta.getLaivat().get(0).getRuudut().get(0).setTuhoutunut(true);
        assertEquals(false, lauta.kaikkiLaivatTuhottu());
    }

    @Test
    public void laivatTuhottuKunKaikkiTuhoutuneet() {
        ArrayList<Ruutu> laivanRuudut = luoListaRuuduista();
        lauta.alustaLaiva(laivanRuudut);
        lauta.getLaivat().get(0).getRuudut().get(0).setAmmuttu(true);
        lauta.getLaivat().get(0).getRuudut().get(0).setTuhoutunut(true);
        lauta.getLaivat().get(0).getRuudut().get(1).setAmmuttu(true);
        lauta.getLaivat().get(0).getRuudut().get(1).setTuhoutunut(true);
        assertEquals(true, lauta.kaikkiLaivatTuhottu());
    }

    @Test
    public void laivanLisaysToimiiKunRuutuPelilaudalla() {
        ArrayList<Ruutu> laivanRuudut = luoListaRuuduista();
        lauta.alustaLaiva(laivanRuudut);

        laivanRuudut.get(0).setSisaltaaLaivan(true);
        laivanRuudut.get(1).setSisaltaaLaivan(true);
        Laiva laiva = new Laiva(laivanRuudut);

        assertEquals(laiva, lauta.getLaivat().get(0));
    }

    @Test
    public void laivaaEiLisataKunRuutuLaudanUlkopuolella() {
        ArrayList<Ruutu> laivanRuudut = new ArrayList<>();
        laivanRuudut.add(new Ruutu(-1, 2));
        laivanRuudut.add(new Ruutu(0, 2));

        lauta.alustaLaiva(laivanRuudut);

        assertEquals(true, lauta.getLaivat().isEmpty());
    }

    public ArrayList<Ruutu> luoListaRuuduista() {
        ArrayList<Ruutu> laivanRuudut = new ArrayList<>();
        laivanRuudut.add(new Ruutu(1, 2));
        laivanRuudut.add(new Ruutu(1, 3));
        return laivanRuudut;
    }
}
