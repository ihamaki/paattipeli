package paatti.logiikka;

import java.util.ArrayList;
import java.util.List;

/**
 * Lauta pitää sisällään kaksiulotteisen taulukon pelilaudan ruuduista, sekä
 * listana tiedon laudalle lisätyistä laivoista. Lauta tarjoaa metodit peli-
 * tilanteen muuttamiseen ja päivittämiseen.
 */

public class Lauta {

    private int koko;
    private Ruutu[][] ruudut;
    private List<Laiva> laivat;
    
    /**
     * Laudan konstruktori. 
     * 
     * @param koko pelilaudan yhden sivun pituus
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

    public void lisaaLaivat() {
        // laivojen lisäys käyttöliittymän avulla
        Laiva eka = new Laiva(2);
        ruudut[1][2].setLaiva(eka);
        ruudut[1][3].setLaiva(eka);
        laivat.add(eka);
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
                System.out.println("laiva");
                return false;
            }
        }

        return this.koko == verrattava.koko;
    }
}
