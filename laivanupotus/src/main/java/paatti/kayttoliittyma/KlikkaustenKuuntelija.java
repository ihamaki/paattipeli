package paatti.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import paatti.logiikka.Lauta;
import paatti.logiikka.Peli;

/**
 * Luokka reagoi pelilaudan graafisen käyttöliittymän painikkeiden klikkauksiin,
 * ja päivittää pelitilanteen niiden perusteella.
 */

public class KlikkaustenKuuntelija implements ActionListener {
    
    private Peli peli;
    private Lauta lauta1;
    private Lauta lauta2;
    private JButton[][] painikkeet1;
    private JButton[][] painikkeet2;
    private Pelikentta pelaaja1;
    private Pelikentta pelaaja2;

    public KlikkaustenKuuntelija(Peli peli, JButton[][] painikkeet1, 
            JButton[][] painikkeet2, Pelikentta pelaaja1, Pelikentta pelaaja2) {
        this.peli = peli;
        this.lauta1 = peli.getLauta1();
        this.lauta2 = peli.getLauta2();
        this.painikkeet1 = painikkeet1;
        this.painikkeet2 = painikkeet2;
        this.pelaaja1 = pelaaja1;
        this.pelaaja2 = pelaaja2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Lauta pelattava = peli.getPelattava();
        if (pelattava == lauta1) {
            haePelatunRuudunKoordinaatit(lauta1, painikkeet1, pelaaja1, e);
        } else if (pelattava == lauta2) {
            haePelatunRuudunKoordinaatit(lauta2, painikkeet2, pelaaja2, e);
        }
    }
    
    public void haePelatunRuudunKoordinaatit(Lauta lauta, JButton[][] painikkeet,
            Pelikentta pelaaja, ActionEvent e) {
        for (int i = 0; i < painikkeet.length; i++) {
            for (int j = 0; j < painikkeet.length; j++) {
                if (painikkeet[i][j] == e.getSource()) {
                    ammu(i, j, lauta, pelaaja);
                }
            }
        }
    }
    
    public void ammu(int x, int y, Lauta lauta, Pelikentta pelaaja) {
        lauta.ammu(x, y);
        pelaaja.paivita(lauta);
    }

}
