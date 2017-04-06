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
    private Pelikentta pelaaja1;
    private Pelikentta pelaaja2;

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    public void ammu(int x, int y, Lauta lauta, JButton[][] painikkeet) {
        
    }

}
