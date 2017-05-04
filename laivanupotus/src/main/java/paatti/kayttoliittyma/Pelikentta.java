package paatti.kayttoliittyma;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import paatti.logiikka.Lauta;
import paatti.logiikka.Peli;
import paatti.logiikka.Ruutu;

public class Pelikentta extends JPanel {

    private Peli peli;
    private JButton[][] painikkeet;

    public Pelikentta(Peli peli, JButton[][] painikkeet) {
        super(new GridLayout(10, 10));
        this.peli = peli;
        this.painikkeet = painikkeet;
        alusta();
    }

    public void alusta() {
        for (int i = 0; i < painikkeet.length; i++) {
            for (int j = 0; j < painikkeet.length; j++) {
                add(painikkeet[i][j]);
            }
        }
    }

    public void paivita(Lauta lauta) {
        for (int i = 0; i < lauta.getKoko(); i++) {
            for (int j = 0; j < lauta.getKoko(); j++) {
                Ruutu ruutu = lauta.getRuudut()[i][j];
                JButton painike = painikkeet[i][j];
                if (ruutu.getAmmuttu()) {
                    if (ruutu.getLaiva() != null) {
                        if (ruutu.getLaiva().getTuhoutunut()) {
                            painike.setBackground(Color.RED);
                        } else {
                            painike.setBackground(Color.DARK_GRAY);
                        }
                        painike.setEnabled(false);
                    } else {
                        painike.setEnabled(false);
                        painike.setBackground(null);
                    }
                } else {
                    painike.setEnabled(true);
                    painike.setBackground(null);
                }
            }
        }
    }

    public void naytaLaivat(Lauta lauta) {
        for (int i = 0; i < lauta.getKoko(); i++) {
            for (int j = 0; j < lauta.getKoko(); j++) {
                Ruutu ruutu = lauta.getRuudut()[i][j];
                JButton painike = painikkeet[i][j];
                if (ruutu.getLaiva() != null) {
                    if (ruutu.getLaiva().getTuhoutunut()) {
                        painike.setBackground(Color.ORANGE);
                    } else {
                        painike.setBackground(Color.DARK_GRAY);
                    }
                    painike.setEnabled(false);
                } else {
                    painike.setEnabled(true);
                }
            }
        }
    }

    public void piilotaKaikki(Lauta lauta) {
        for (int i = 0; i < lauta.getKoko(); i++) {
            for (int j = 0; j < lauta.getKoko(); j++) {
                painikkeet[i][j].setBackground(null);
                painikkeet[i][j].setEnabled(false);
            }
        }
    }
}
