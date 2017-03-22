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
                if (ruudut[rivi][sarake].isSisaltaaLaivan()) {
                    System.out.print("\t[*]");
//                }
//                if (ruudut[rivi][sarake].isTuhoutunut()) {
//                    System.out.print("\t[X]");
//                } else if (ruudut[rivi][sarake].isAmmuttu()) {
//                    System.out.print("\t[0]");
                } else {
                    System.out.print("\t[ ]");
                }
            }
            System.out.println("");
        }
    }

    public void alustaLaivat(int x, int y) {
        List<Ruutu> laivanRuudut = new ArrayList<>();
        Ruutu ruutu = ruudut[x][y];
        ruutu.setSisaltaaLaivan(true);
        laivanRuudut.add(ruutu);
        Laiva laiva = new Laiva(laivanRuudut);
        laivat.add(laiva);
    }

    @Override
    public String toString() {
        return "" + this.ruudut;
    }

}
