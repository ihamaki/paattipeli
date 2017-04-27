package paatti.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
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
    private ArrayList<JButton> napit1;
    private ArrayList<JButton> napit2;
    private JLabel ohje;

    private enum TILA {
        ALKU,
        PELI
    };

    private TILA tila;

    public Kayttoliittyma(int koko) {
        this.koko = koko;
        this.peli = new Peli(koko);
        this.painikkeet1 = new JButton[koko][koko];
        this.painikkeet2 = new JButton[koko][koko];
        alustaPainikkeet(painikkeet1);
        alustaPainikkeet(painikkeet2);
        pelaaja1 = new Pelikentta(peli, painikkeet1);
        pelaaja2 = new Pelikentta(peli, painikkeet2);
        tila = TILA.ALKU;
    }

    @Override
    public void run() {
        frame = new JFrame("Laivanupotus");
        frame.setPreferredSize(new Dimension(1000, 500));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        if (tila == TILA.PELI) {
            luoPelinKomponentit(frame.getContentPane());
            KlikkaustenKuuntelija k = new KlikkaustenKuuntelija(this, peli, painikkeet1,
                    painikkeet2, pelaaja1, pelaaja2, ohje);
            lisaaPainikkeilleKuuntelija(k, painikkeet1);
            lisaaPainikkeilleKuuntelija(k, painikkeet2);
        } else if (tila == TILA.ALKU) {
            luoAlkunakymanKomponentit(frame.getContentPane());
            valitseNaytettavaLauta();
            LaivojenKuuntelija l = new LaivojenKuuntelija(this, peli, painikkeet1,
                    painikkeet2, pelaaja1, pelaaja2, napit1, napit2, ohje);
            lisaaPainikkeilleKuuntelija(l, painikkeet1);
            lisaaPainikkeilleKuuntelija(l, painikkeet2);
            lisaaNapeilleKuuntelija(l, napit1);
            lisaaNapeilleKuuntelija(l, napit2);
        }

        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    /**
     * Metodi luo käyttöliittymän eri komponentit.
     *
     * @param container
     */
    private void luoPelinKomponentit(Container container) {
        container.setLayout(new BorderLayout());
        JPanel pelaajat = new JPanel(new GridLayout());
        JPanel kentat = new JPanel(new GridLayout(1, 0));

        ohje = new JLabel("Pelaajan 1 vuoro", SwingConstants.CENTER);
        JLabel pel1 = new JLabel("Pelaaja 1", SwingConstants.CENTER);
        JLabel pel2 = new JLabel("Pelaaja 2", SwingConstants.CENTER);

        pelaajat.add(pel1);
        pelaajat.add(pel2);
        kentat.add(pelaaja1);
        kentat.add(pelaaja2);
        pelaaja1.paivita(peli.getLauta1());
        pelaaja2.paivita(peli.getLauta2());

        container.add(pelaajat, BorderLayout.NORTH);
        container.add(kentat, BorderLayout.CENTER);
        container.add(ohje, BorderLayout.SOUTH);
    }

    private void luoAlkunakymanKomponentit(Container container) {
        container.setLayout(new BorderLayout());
        JPanel pelaajat = new JPanel(new GridLayout());
        JPanel kentat = new JPanel(new GridLayout(1, 0));
        JPanel laivat1 = new JPanel();
        JPanel laivat2 = new JPanel();
        laivat1.setLayout(new BoxLayout(laivat1, BoxLayout.Y_AXIS));
        laivat2.setLayout(new BoxLayout(laivat2, BoxLayout.Y_AXIS));

        JLabel pel1 = new JLabel("Pelaaja 1", SwingConstants.CENTER);
        JLabel pel2 = new JLabel("Pelaaja 2", SwingConstants.CENTER);
        ohje = new JLabel("Pelaaja 1: Aseta laivat laudalle", SwingConstants.CENTER);

        napit1 = luoNapit(laivat1, true);
        napit2 = luoNapit(laivat2, false);
        pelaajat.add(pel1);
        pelaajat.add(pel2);
        kentat.add(pelaaja1);
        kentat.add(pelaaja2);
        pelaaja2.piilotaKaikki(peli.getLauta2());

        container.add(pelaajat, BorderLayout.NORTH);
        container.add(ohje, BorderLayout.SOUTH);
        container.add(laivat1, BorderLayout.WEST);
        container.add(laivat2, BorderLayout.EAST);
        container.add(kentat, BorderLayout.CENTER);
    }

    private ArrayList<JButton> luoNapit(Container container, boolean kaytossa) {
        ArrayList<JButton> napit = new ArrayList<>();
        napit.add(new JButton("*"));
        napit.add(new JButton("**"));
        napit.add(new JButton("***"));
        napit.add(new JButton("****"));
        napit.add(new JButton("*****"));

        for (JButton nappi : napit) {
            nappi.setEnabled(kaytossa);
            container.add(nappi);
        }

        JButton vaaka = new JButton("vaaka");
        JButton pysty = new JButton("pysty");
        vaaka.setEnabled(false);
        pysty.setEnabled(kaytossa);
        napit.add(vaaka);
        napit.add(pysty);
        container.add(vaaka);
        container.add(pysty);

        JButton valmis = new JButton("valmis");
        valmis.setEnabled(kaytossa);
        napit.add(valmis);
        container.add(valmis);

        return napit;
    }

    public JFrame getFrame() {
        return frame;
    }

    public Peli getPeli() {
        return peli;
    }

    public void vaihdaTila() {
        if (tila == TILA.ALKU) {
            tila = TILA.PELI;
        } else if (tila == TILA.PELI) {
            tila = TILA.ALKU;
        }
    }

    public void valitseNaytettavaLauta() {
        if (peli.getPelattava() == 1) {
            pelaaja1.naytaLaivat(peli.getLauta1());
            pelaaja2.piilotaKaikki(peli.getLauta2());
            for (JButton nappi : napit1) {
                nappi.setEnabled(true);
            }
            napit1.get(napit1.size() - 3).setEnabled(false);
            for (JButton nappi : napit2) {
                nappi.setEnabled(false);
            }
        } else if (peli.getPelattava() == 2) {
            pelaaja2.naytaLaivat(peli.getLauta2());
            pelaaja1.piilotaKaikki(peli.getLauta1());
            for (JButton nappi : napit2) {
                nappi.setEnabled(true);
            }
            napit2.get(napit2.size() - 3).setEnabled(false);
            for (JButton nappi : napit1) {
                nappi.setEnabled(false);
            }
        }
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
    public void lisaaPainikkeilleKuuntelija(ActionListener kuuntelija,
            JButton[][] painikkeet) {
        for (int i = 0; i < painikkeet.length; i++) {
            for (int j = 0; j < painikkeet.length; j++) {
                painikkeet[i][j].addActionListener(kuuntelija);
            }
        }
    }

    public void lisaaNapeilleKuuntelija(ActionListener kuuntelija, ArrayList<JButton> napit) {
        for (JButton nappi : napit) {
            nappi.addActionListener(kuuntelija);
        }
    }

}
