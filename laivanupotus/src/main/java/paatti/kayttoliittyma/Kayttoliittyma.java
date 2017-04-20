package paatti.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
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
    private JButton[][] painikkeet1;
    private JButton[][] painikkeet2;
    private JLabel pelinTila;

    public Kayttoliittyma(int koko) {
        this.koko = koko;
        this.peli = new Peli(koko);
        this.painikkeet1 = new JButton[koko][koko];
        this.painikkeet2 = new JButton[koko][koko];
        alustaPainikkeet(painikkeet1);
        alustaPainikkeet(painikkeet2);
        pelaaja1 = new Pelikentta(peli, painikkeet1);
        pelaaja2 = new Pelikentta(peli, painikkeet2);
    }

    @Override
    public void run() {
        frame = new JFrame("Laivanupotus");
        frame.setPreferredSize(new Dimension(800, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        KlikkaustenKuuntelija k = new KlikkaustenKuuntelija(peli, painikkeet1,
                painikkeet2, pelaaja1, pelaaja2, pelinTila);
        lisaaPainikkeilleKuuntelija(k, painikkeet1);
        lisaaPainikkeilleKuuntelija(k, painikkeet2);

        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        this.peli.pelaa();
    }

    /**
     * Metodi luo käyttöliittymän eri komponentit.
     *
     * @param container
     */
    private void luoKomponentit(Container container) {
        container.setLayout(new BorderLayout());
        JPanel pelaajat = new JPanel(new GridLayout());
        JPanel kentat = new JPanel(new GridLayout(1, 0));

        pelinTila = new JLabel("Pelaajan 1 vuoro", SwingConstants.CENTER);
        JLabel pel1 = new JLabel("Pelaaja 1", SwingConstants.CENTER);
        JLabel pel2 = new JLabel("Pelaaja 2", SwingConstants.CENTER);

        pelaajat.add(pel1);
        pelaajat.add(pel2);
        kentat.add(pelaaja1);
        kentat.add(pelaaja2);

        container.add(pelaajat, BorderLayout.NORTH);
        container.add(kentat, BorderLayout.CENTER);
        container.add(pelinTila, BorderLayout.SOUTH);
    }

    public JFrame getFrame() {
        return frame;
    }

    public JLabel getPelinTila() {
        return pelinTila;
    }

    /**
     * Metodi luo uudet JButtonit kaksiulotteiseen taulukkoon.
     *
     * @param painikkeet Kaksiulotteinen taulukko, johon uudet napit lisätään
     */
    public void alustaPainikkeet(JButton[][] painikkeet) {
        for (int i = 0; i < koko; i++) {
            for (int j = 0; j < koko; j++) {
                JButton painike = new JButton();
                painikkeet[i][j] = painike;
            }
        }
    }

    /**
     * Metodi lisää kuuntelijan jokaiselle JButtonille.
     *
     * @param kuuntelija Klikkauksia kuunteleva ja niihin reagoiva kuuntelija
     * @param painikkeet Kaksiulotteinen JButtonit sisältävä taulukko
     */
    public void lisaaPainikkeilleKuuntelija(KlikkaustenKuuntelija kuuntelija,
            JButton[][] painikkeet) {
        for (int i = 0; i < painikkeet.length; i++) {
            for (int j = 0; j < painikkeet.length; j++) {
                painikkeet[i][j].addActionListener(kuuntelija);
            }
        }
    }

}
