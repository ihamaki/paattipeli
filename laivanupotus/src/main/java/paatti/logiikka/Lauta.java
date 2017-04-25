package paatti.logiikka;

import java.util.ArrayList;
import java.util.List;

/**
 * Lauta pitää sisällään kaksiulotteisen taulukon pelilaudan ruuduista, sekä
 * listana tiedon laudalle lisätyistä laivoista. Lauta tarjoaa metodit laivojen
 * lisäämiseen pelilaudalle, sekä metodit peli- tilanteen muuttamiseen ja
 * päivittämiseen.
 */
public class Lauta {

    private int koko;
    private Ruutu[][] ruudut;
    private List<Laiva> laivat;

    /**
     * Laudan konstruktori.
     *
     * @param koko Pelilaudan yhden sivun pituus
     */
    public Lauta(int koko) {
        this.koko = koko;
        this.ruudut = new Ruutu[koko][koko];
        alustaLauta();
        this.laivat = new ArrayList<>();
    }

    public int getKoko() {
        return koko;
    }

    public Ruutu[][] getRuudut() {
        return ruudut;
    }

    public List<Laiva> getLaivat() {
        return laivat;
    }

    public void setLaivat(List<Laiva> laivat) {
        this.laivat = laivat;
    }

    /**
     * Metodi tarkistaa sille parametreina annettujen koordinaattien
     * kelpoisuuden, ja ampuu tämän jälkeen koordinaatteja vastaavaa ruutua.
     * Metodi päivittää ammutun ruudun muuttujia sen mukaan, onko ruudussa laiva
     * vai ei.
     *
     * @param x Ammuttavan ruudun x-koordinaatti
     * @param y Ammuttavan ruudun y-koordinaatti
     */
    public void ammu(int x, int y) {
        if (x < 0 || y < 0 || x >= koko || y >= koko || ruudut[x][y].getAmmuttu()) {
            return;
        }
        if (ruudut[x][y].getLaiva() != null) {
            ruudut[x][y].getLaiva().ammu();
            ruudut[x][y].setTuhoutunut(true);
        }
        ruudut[x][y].setAmmuttu(true);
    }

    /**
     * Metodi lisää laudalle yhden laivan. Laiva rakennetaan
     * aloituskoordinaateista joko oikealle tai alas, riippuen suunnasta.
     *
     * @param laivanKoko Laivan koko
     * @param suunta Laivan suunta, 1 jos vaaka, -1 jos pysty
     * @param x Laivan ensimmäisen ruudun x-koordinaatti
     * @param y Laivan ensimmäisen ruudun y-koordinaatti
     * @return true jos laivan lisäys onnistuu, false muuten
     */
    public boolean lisaaLaiva(int laivanKoko, int suunta, int x, int y) {
        if (!tarkistaLaivanKelpoisuus(laivanKoko, suunta, x, y)) {
            return false;
        }
        Laiva laiva = new Laiva(laivanKoko);
        for (int i = 0; i < laivanKoko; i++) {
            ruudut[x][y].setLaiva(laiva);
            if (suunta < 0) {
                x++;
            } else {
                y++;
            }
        }
        laivat.add(laiva);
        return true;
    }

    /**
     * Metodi tarkistaa, voiko laudalle lisätä laivan parametrien ehdoilla.
     * Laivaa ei voi lisätä toisen laivan päälle.
     *
     * @param laivanKoko Laivan koko
     * @param suunta Laivan suunta, 1 jos vaaka, -1 jos pysty
     * @param x Laivan ensimmäisen ruudun x-koordinaatti
     * @param y Laivan ensimmäisen ruudun y-koordinaatti
     * @return true jos laivan lisäys onnistuu, false muuten
     */
    public boolean tarkistaLaivanKelpoisuus(int laivanKoko, int suunta, int x, int y) {
        for (int i = 0; i < laivanKoko; i++) {
            if (x < 0 || y < 0 || x >= koko || y >= koko
                    || ruudut[x][y].getLaiva() != null) {
                return false;
            }
            if (suunta < 0) {
                x++;
            } else {
                y++;
            }
        }
        return true;
    }

    /**
     * Metodi tarkistaa pelilaudan laivojen statuksen.
     *
     * @return true jos kaikki pelilaudan laivat tuhottu, muuten false
     */
    public boolean kaikkiLaivatTuhottu() {
        int tuhottu = 0;
        for (Laiva laiva : laivat) {
            if (laiva.getTuhoutunut()) {
                tuhottu++;
            }
        }
        return tuhottu == laivat.size();
    }

    /**
     * Metodi alustaa laudan luomalla ruudut kaksiulotteiseen taulukkoon.
     */
    public void alustaLauta() {
        for (int rivi = 0; rivi < koko; rivi++) {
            for (int sarake = 0; sarake < koko; sarake++) {
                this.ruudut[rivi][sarake] = new Ruutu(rivi, sarake);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }

        Lauta verrattava = (Lauta) o;

        for (int i = 0; i < laivat.size(); i++) {
            if (this.laivat.get(i) != verrattava.laivat.get(i)) {
                return false;
            }
        }

        return this.koko == verrattava.koko;
    }
}
