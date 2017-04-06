package paatti.laivanupotus;

import java.util.Scanner;
import javax.swing.SwingUtilities;
import paatti.kayttoliittyma.Kayttoliittyma;
import paatti.logiikka.Peli;

/**
 * Luokka käynnistää pelin graafisen käyttöliittymän.
 */
public class Main {

    public static void main(String[] args) {
        Kayttoliittyma k = new Kayttoliittyma(10);
        SwingUtilities.invokeLater(k);
    }
}
