package paatti.logiikka;

import java.util.ArrayList;
import java.util.List;

public class Lauta {

    private int koko;
    private Ruutu[][] ruudut;
    private List<Laiva> laivat;

    public Lauta(int koko) {
        this.koko = koko;
        this.ruudut = new Ruutu[koko][koko];
        alustaLauta();
        this.laivat = new ArrayList<>();
    }

    public int getKoko() {
        return koko;
    }

    public void setKoko(int koko) {
        this.koko = koko;
    }

    public Ruutu[][] getRuudut() {
        return ruudut;
    }

    public void setRuudut(Ruutu[][] ruudut) {
        this.ruudut = ruudut;
    }

    public List<Laiva> getLaivat() {
        return laivat;
    }

    public void setLaivat(List<Laiva> laivat) {
        this.laivat = laivat;
    }

    public void alustaLauta() {
        for (int rivi = 0; rivi < koko; rivi++) {
            for (int sarake = 0; sarake < koko; sarake++) {
                this.ruudut[rivi][sarake] = new Ruutu(rivi, sarake);
            }
        }
    }

    public void tulostaLauta() {
        for (int i = 0; i < koko; i++) {
            System.out.print("\t " + (i + 1));
        }
        System.out.println("");

        for (int rivi = 0; rivi < koko; rivi++) {
            System.out.print((rivi + 1));
            for (int sarake = 0; sarake < koko; sarake++) {
                if (ruudut[rivi][sarake].isAmmuttu()) {
                    if (ruudut[rivi][sarake].isTuhoutunut()) {
                        System.out.print("\t[X]");
                    } else {
                        System.out.print("\t[0]");
                    }
                } else {
                    System.out.print("\t[ ]");
                }
            }
            System.out.println("");
        }
    }

    public void tulostaLautaJaLaivat() {
        for (int i = 0; i < koko; i++) {
            System.out.print("\t " + (i + 1));
        }
        System.out.println("");

        for (int rivi = 0; rivi < koko; rivi++) {
            System.out.print((rivi + 1));
            for (int sarake = 0; sarake < koko; sarake++) {
                if (ruudut[rivi][sarake].isSisaltaaLaivan()) {
                    System.out.print("\t[*]");
                } else {
                    System.out.print("\t[ ]");
                }
            }
            System.out.println("");
        }
    }

    public void alustaLaiva(int x, int y) {
        if (x < 0 || x >= koko || y < 0 || y >= koko) {
            return;
        }
        Laiva laiva = new Laiva();
        Ruutu ruutu = ruudut[x][y];
        ruutu.setSisaltaaLaivan(true);
        laiva.lisaaRuutu(ruutu);
        laivat.add(laiva);
    }

    @Override
    public String toString() {
        return "" + this.ruudut;
    }

}
