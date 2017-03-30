package paatti.laivanupotus;

import java.util.Scanner;
import paatti.logiikka.Peli;

public class Main {
    
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Peli paattipeli = new Peli(5);
        paattipeli.pelaa();
    }
}
