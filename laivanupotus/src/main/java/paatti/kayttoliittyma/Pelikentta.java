package paatti.kayttoliittyma;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import paatti.logiikka.Lauta;
import paatti.logiikka.Peli;
import paatti.logiikka.Ruutu;

/**
 * Pelikenttä on graafinen esitys yhden pelaajan pelilaudalle, ja on siis osa
 * graafista käyttöliittymää. Pelikenttä tarjoaa metodin pelin graafisen
 * näkymän päivittämiseen.
 */

public class Pelikentta extends JPanel {
    private Lauta lauta;
    private JButton[][] painikkeet;

    public Pelikentta(Lauta lauta) {
        super(new GridLayout(10, 10));
        this.lauta = lauta;
        this.painikkeet = new JButton[this.lauta.getKoko()][this.lauta.getKoko()];
        alustaPainikkeet();
    }
    
    public void alustaPainikkeet() {
        for (int i = 0; i < lauta.getKoko(); i++) {
            for (int j = 0; j < lauta.getKoko(); j++) {
                JButton painike = new JButton();
                painikkeet[i][j] = painike;
                add(painike);
            }
        }
    }
    
    public void paivita() {
        for (int i = 0; i < lauta.getKoko(); i++) {
            for (int j = 0; j < lauta.getKoko(); j++) {
                Ruutu ruutu = lauta.getRuudut()[i][j];
                JButton painike = painikkeet[i][j];
                if (!ruutu.getAmmuttu()) {
                    if (ruutu.getTuhoutunut()) {
                        painike.setEnabled(false);
                        painike.setBackground(Color.RED);
                    } else {
                        painike.setEnabled(false);
                    }
                } else {
                    painike.setEnabled(true);
                }
            }
        }
    }
}
