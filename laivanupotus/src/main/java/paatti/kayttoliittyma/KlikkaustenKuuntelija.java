package paatti.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import paatti.logiikka.Lauta;
import paatti.logiikka.Peli;

public class KlikkaustenKuuntelija implements ActionListener {

    private Kayttoliittyma kayttoliittyma;
    private Peli peli;
    private Lauta lauta1;
    private Lauta lauta2;
    private JButton[][] painikkeet1;
    private JButton[][] painikkeet2;
    private Pelikentta pelaaja1;
    private Pelikentta pelaaja2;
    private JLabel pelinTila;

    public KlikkaustenKuuntelija(Kayttoliittyma kayttoliittyma, Peli peli, JButton[][] painikkeet1,
            JButton[][] painikkeet2, Pelikentta pelaaja1, Pelikentta pelaaja2, JLabel pelinTila) {
        this.kayttoliittyma = kayttoliittyma;
        this.peli = peli;
        this.lauta1 = peli.getLauta1();
        this.lauta2 = peli.getLauta2();
        this.painikkeet1 = painikkeet1;
        this.painikkeet2 = painikkeet2;
        this.pelaaja1 = pelaaja1;
        this.pelaaja2 = pelaaja2;
        this.pelinTila = pelinTila;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (peli.onkoPeliPaattynyt()) {
            return;
        }
        int pelattava = peli.getPelattava();
        if (pelattava == 1) {
            haePelatunRuudunKoordinaatit(lauta1, painikkeet1, pelaaja1, e);
        } else if (pelattava == 2) {
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
        paivitaPelinTila();
        pelaaja.paivita(lauta);
    }

    public void paivitaPelinTila() {
        if (peli.onkoPeliPaattynyt()) {
            peli.vaihdaPelattava();
            pelinTila.setText("Pelaaja " + peli.getPelattava() + " voitti!");
        } else {
            pelinTila.setText("Pelaajan " + peli.getPelattava() + " vuoro");
            peli.vaihdaPelattava();
        }
    }

}
