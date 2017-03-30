package paatti.logiikka;

import java.util.ArrayList;

public class Peli {
    
    private Lauta lauta1;
    private Lauta lauta2;

    public Peli(int koko) {
        this.lauta1 = new Lauta(koko);
        this.lauta2 = new Lauta(koko);
    }

    public Lauta getLauta1() {
        return lauta1;
    }

    public Lauta getLauta2() {
        return lauta2;
    }

    public void pelaa() {
        System.out.println("Tervetuloa peliin!");
        paivitaPeli();
        lisaaLaivat(lauta1, lauta2);
        
        // laivojen sijainnit
//        lauta1.tulostaLautaJaLaivat();
//        lauta2.tulostaLautaJaLaivat();

//        ammu(0,0, lauta1);
//        ammu(1,0, lauta1);
//        ammu(2,0, lauta1);
//        
//        paivitaPeli();
//        
//        while (!lauta1.kaikkiLaivatTuhottu() && !lauta2.kaikkiLaivatTuhottu()) {
//            // varsinainen peli
//        }
    }
    
    public void ammu(int x, int y, Lauta lauta) {
        if (lauta.getRuudut()[x][y].isSisaltaaLaivan()) {
            lauta.getRuudut()[x][y].setAmmuttu(true);
            lauta.getRuudut()[x][y].setTuhoutunut(true);
        } else {
            lauta.getRuudut()[x][y].setAmmuttu(true);
        }
        lauta.ammuLaivanRuudut(x, y);
    }
    
    public void paivitaPeli() {
        System.out.println("\nPelaaja 1");
        lauta1.tulostaLauta();
        System.out.println("\nPelaaja 2");
        lauta2.tulostaLauta();
    }
    
    public void lisaaLaivat(Lauta lauta1, Lauta lauta2) {
        // alustetaan laivojen ruudut
        // varsinainen laivojen luonti käyttöliittymän avulla
        ArrayList<Ruutu> laivanRuudut1 = new ArrayList<>();
        ArrayList<Ruutu> laivanRuudut2 = new ArrayList<>();
        
        laivanRuudut1.add(new Ruutu(1, 2));
        laivanRuudut1.add(new Ruutu(1, 3));
        laivanRuudut1.add(new Ruutu(1, 4));
        
        laivanRuudut2.add(new Ruutu(2, 2));
        laivanRuudut2.add(new Ruutu(3, 2));
        laivanRuudut2.add(new Ruutu(4, 2));
        
        lauta1.alustaLaiva(laivanRuudut1);
        lauta2.alustaLaiva(laivanRuudut2);
    }

}
