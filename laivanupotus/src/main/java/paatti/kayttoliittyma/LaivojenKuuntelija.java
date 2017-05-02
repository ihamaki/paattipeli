package paatti.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import paatti.logiikka.Lauta;
import paatti.logiikka.Peli;

public class LaivojenKuuntelija implements ActionListener {

    private Kayttoliittyma kayttoliittyma;
    private Peli peli;
    private JButton[][] painikkeet1;
    private JButton[][] painikkeet2;
    private Pelikentta pelaaja1;
    private Pelikentta pelaaja2;
    private ArrayList<JButton> napit1;
    private ArrayList<JButton> napit2;
    private JLabel ohje;
    private JButton valittuLaiva;
    private int koko;
    private int suunta;

    public LaivojenKuuntelija(Kayttoliittyma kayttoliittyma, Peli peli, JButton[][] painikkeet1,
            JButton[][] painikkeet2, Pelikentta pelaaja1, Pelikentta pelaaja2, ArrayList<JButton> napit1,
            ArrayList<JButton> napit2, JLabel ohje) {
        this.kayttoliittyma = kayttoliittyma;
        this.peli = peli;
        this.painikkeet1 = painikkeet1;
        this.painikkeet2 = painikkeet2;
        this.pelaaja1 = pelaaja1;
        this.pelaaja2 = pelaaja2;
        this.napit1 = napit1;
        this.napit2 = napit2;
        this.ohje = ohje;
        this.koko = 0;
        this.suunta = 1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int pelattava = peli.getPelattava();
        if (pelattava == 1) {
            haeValittuNappi(e, napit1);
            haePelatunRuudunKoordinaatit(peli.getLauta1(), painikkeet1, pelaaja1, e);
        } else if (pelattava == 2) {
            haeValittuNappi(e, napit2);
            haePelatunRuudunKoordinaatit(peli.getLauta2(), painikkeet2, pelaaja2, e);
        }
    }

    public void haeValittuNappi(ActionEvent e, ArrayList<JButton> napit) {
        for (int i = 0; i < napit.size() - 3; i++) {
            if (napit.get(i) == e.getSource()) {
                valittuLaiva = napit.get(i);
                koko = i + 1;
            }
        }

        if (napit.get(napit.size() - 3) == e.getSource()) {
            suunta = 1;
            napit.get(napit.size() - 3).setEnabled(false);
            napit.get(napit.size() - 2).setEnabled(true);
        }

        if (napit.get(napit.size() - 2) == e.getSource()) {
            suunta = -1;
            napit.get(napit.size() - 3).setEnabled(true);
            napit.get(napit.size() - 2).setEnabled(false);
        }

        if (napit.get(napit.size() - 1) == e.getSource()) {
            if (peli.getPelattava() == 1) {
                if (kayttoliittyma.getPeli().getLauta1().onkoKaikkiLaivatLisatty()) {
                    kayttoliittyma.getPeli().vaihdaPelattava();
                    kayttoliittyma.valitseNaytettavaLauta();
                    suunta = 1;
                    ohje.setText("Pelaaja " + peli.getPelattava() + ": Aseta laivat laudalle");
                } else {
                    ohje.setText("Kaikki laivat tulee sijoittaa pelilaudalle");
                }
            } else if (peli.getPelattava() == 2) {
                if (kayttoliittyma.getPeli().getLauta2().onkoKaikkiLaivatLisatty()) {
                    kayttoliittyma.vaihdaTila();
                    kayttoliittyma.run();
                } else {
                    ohje.setText("Kaikki laivat tulee sijoittaa pelilaudalle");
                }
            }
        }
    }

    public void haePelatunRuudunKoordinaatit(Lauta lauta, JButton[][] painikkeet,
            Pelikentta pelaaja, ActionEvent e) {
        for (int i = 0; i < painikkeet.length; i++) {
            for (int j = 0; j < painikkeet.length; j++) {
                if (painikkeet[i][j] == e.getSource()) {
                    if (valittuLaiva != null) {
                        if (kayttoliittyma.getPeli().lisaaLaiva(lauta, koko, suunta, i, j)) {
                            valittuLaiva.setEnabled(false);
                            valittuLaiva = null;
                            koko = 0;
                            pelaaja.naytaLaivat(lauta);
                            ohje.setText("Pelaaja " + peli.getPelattava() + ": Aseta laivat laudalle");
                        } else {
                            ohje.setText("Laivaa ei voi sijoittaa toisen laivan päälle tai pelilaudan ulkopuolelle");
                        }
                    } else {
                        ohje.setText("Valitse laudalle sijoitettavan laivan koko");
                    }
                }
            }
        }
    }

}
