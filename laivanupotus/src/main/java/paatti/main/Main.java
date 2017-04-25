package paatti.main;

import java.util.Scanner;
import javax.swing.SwingUtilities;
import paatti.kayttoliittyma.Kayttoliittyma;
import paatti.logiikka.Lauta;
import paatti.logiikka.Peli;
import paatti.logiikka.Ruutu;

/**
 * Luokka käynnistää pelin graafisen käyttöliittymän.
 */
public class Main {

    public static void main(String[] args) {
        Kayttoliittyma k = new Kayttoliittyma(10);
        SwingUtilities.invokeLater(k);
    }
}
