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
 * graafista käyttöliittymää. Pelikenttä tarjoaa metodin pelin graafisen näkymän
 * päivittämiseen.
 */
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

    /**
     * Metodi päivittää pelilaudan tilanteen.
     *
     * @param paivitettyLauta Päivitetty lauta, jonka perusteella graafinen
     * lautanäkymä luodaan
     */
    public void paivita(Lauta paivitettyLauta) {
        Lauta lauta = paivitettyLauta;
        for (int i = 0; i < lauta.getKoko(); i++) {
            for (int j = 0; j < lauta.getKoko(); j++) {
                Ruutu ruutu = lauta.getRuudut()[i][j];
                JButton painike = painikkeet[i][j];
                if (ruutu.getAmmuttu()) {
                    if (ruutu.getLaiva() != null && ruutu.getAmmuttu()) {
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
