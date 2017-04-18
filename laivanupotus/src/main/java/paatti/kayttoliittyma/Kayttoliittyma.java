package paatti.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import paatti.logiikka.Peli;

/**
 * Luokka luo pelille graafisen käyttöliittymän.
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private int koko;
    private Peli peli;
    private Pelikentta pelaaja1;
    private Pelikentta pelaaja2;

    public Kayttoliittyma(int koko) {
        this.koko = koko;
        this.peli = new Peli(koko);
        pelaaja1 = new Pelikentta(peli.getLauta1());
        pelaaja2 = new Pelikentta(peli.getLauta2());
    }

    @Override
    public void run() {
        frame = new JFrame("Laivanupotus");
        frame.setPreferredSize(new Dimension(800, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        KlikkaustenKuuntelija k = new KlikkaustenKuuntelija(peli, pelaaja1.getPainikkeet(),
                pelaaja2.getPainikkeet(), pelaaja1, pelaaja2);
        lisaaPainikkeilleKuuntelija(k, pelaaja1.getPainikkeet());
        lisaaPainikkeilleKuuntelija(k, pelaaja2.getPainikkeet());

        frame.pack();
        frame.setVisible(true);
        this.peli.pelaa();
    }

    private void luoKomponentit(Container container) {
        container.setLayout(new GridLayout(1, 0));

        container.add(pelaaja1);
        container.add(pelaaja2);
    }

    public JFrame getFrame() {
        return frame;
    }

//    public void alustaPainikkeet() {
//        for (int i = 0; i < lauta.getKoko(); i++) {
//            for (int j = 0; j < lauta.getKoko(); j++) {
//                JButton painike = new JButton();
//                painikkeet[i][j] = painike;
//                add(painike);
//            }
//        }
//    }

    public void lisaaPainikkeilleKuuntelija(KlikkaustenKuuntelija kuuntelija,
            JButton[][] painikkeet) {
        for (int i = 0; i < painikkeet.length; i++) {
            for (int j = 0; j < painikkeet.length; j++) {
                painikkeet[i][j].addActionListener(kuuntelija);
            }
        }
    }

}
