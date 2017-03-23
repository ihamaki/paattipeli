package paatti.logiikka;

import java.util.Scanner;

public class Peli {
    
    private Lauta lauta1;
    private Lauta lauta2;
    private Scanner lukija;

    public Peli(int koko, Scanner lukija) {
        this.lauta1 = new Lauta(koko);
        this.lauta2 = new Lauta(koko);
        this.lukija = lukija;
    }

    public void pelaa() {
        System.out.println("Tervetuloa peliin!");
        paivitaPeli();
        System.out.println("\nSyötetään laivojen koordinaatit. Laivoja on 3, ja niiden kaikkien koko on 1. Koordinaatit ovat välillä 1-5.\n");
        System.out.println("Pelaaja 1, syötä laivat: ");
        lisaaLaivat(lauta1);
        System.out.println("Pelaaja 2, syötä laivat: ");
        lisaaLaivat(lauta2);
        lauta1.tulostaLautaJaLaivat();
        lauta2.tulostaLautaJaLaivat();
    }
    
    public void paivitaPeli() {
        System.out.println("");
        System.out.println("Pelaaja 1");
        lauta1.tulostaLauta();
        System.out.println("");
        System.out.println("Pelaaja 2");
        lauta2.tulostaLauta();
    }
    
    public void lisaaLaivat(Lauta lauta) {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Laiva " + i);
            System.out.print("X: ");
            int x = Integer.parseInt(lukija.nextLine()) - 1;
            System.out.print("Y: ");
            int y = Integer.parseInt(lukija.nextLine()) - 1;
            lauta.alustaLaiva(x, y);
        }
    }

}
