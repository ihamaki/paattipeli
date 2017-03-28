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

    public Ruutu[][] getRuudut() {
        return ruudut;
    }

    public List<Laiva> getLaivat() {
        return laivat;
    }
    
    public boolean kaikkiLaivatTuhottu() {
        int tuhottu = 0;
        for (Laiva laiva : laivat) {
            laiva.tarkistaOnkoTuhoutunut();
            if (laiva.isTuhoutunut()) {
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

    public void alustaLaiva(List<Ruutu> laivanRuudut) {
        for (Ruutu ruutu : laivanRuudut) {
            if (ruutu.getX() < 0 || ruutu.getY() < 0 || ruutu.getX() >= koko || ruutu.getY() >= koko)  {
                return;
            }
            ruudut[ruutu.getX()][ruutu.getY()].setSisaltaaLaivan(true);
        }
        Laiva laiva = new Laiva(laivanRuudut);
        laivat.add(laiva);
    }
}
