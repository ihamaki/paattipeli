package paatti.logiikka;

/**
 * Peli-luokka sisältää pelin perustoiminnallisuuden tarjoavat metodit, kuten
 * tietyn ruudun ampumisen pelilaudalla. Molempien pelaajien pelilautoihin
 * päästään käsiksi tämän luokan kautta. Luokka sisältää myös metodit
 * pelitilanteen tarkistamiseksi, eli onko toinen pelaaja hävinnyt ja onko peli
 * päättynyt.
 */
public class Peli {

    private Lauta lauta1;
    private Lauta lauta2;
    private int pelattava;
    private boolean peliPaattynyt;

    /**
     * Pelin konstruktori. Laudat alustetaan pelille annetun koon mukaan.
     *
     * @param koko Pelilaudan sivun pituus
     */
    public Peli(int koko) {
        this.lauta1 = new Lauta(koko);
        this.lauta2 = new Lauta(koko);
        this.pelattava = 1;
        this.peliPaattynyt = false;
    }

    public Lauta getLauta1() {
        return lauta1;
    }

    public Lauta getLauta2() {
        return lauta2;
    }

    public int getPelattava() {
        return pelattava;
    }

    public boolean getPeliPaattynyt() {
        return peliPaattynyt;
    }

    /**
     * Metodi lisää parametrina annetulle laudalle parametrien mukaisen laivan.
     *
     * @param lauta Lauta, jolle laiva rakennetaan
     * @param koko Laivan koko
     * @param suunta Laivan suunta, 1 jos vaaka, -1 jos pysty
     * @param x Laivan ensimmäisen ruudun x-koordinaatti
     * @param y Laivan ensimmäisen ruudun y-koordinaatti
     * @return true jos laivan lisäys onnistui, false muuten
     */
    public boolean lisaaLaiva(Lauta lauta, int koko, int suunta, int x, int y) {
        if (lauta.lisaaLaiva(koko, suunta, x, y)) {
            return true;
        }
        return false;
    }

    /**
     * Metodi tarkistaa, onko pelaaja hävinnyt tarkistamalla pelaajan laudan
     * laivojen tilanteen.
     *
     * @param lauta Tarkistettava pelilauta
     * @return true jos kaikki laudan laivat on tuhottu, false muuten
     */
    public boolean onkoHavinnyt(Lauta lauta) {
        return lauta.kaikkiLaivatTuhottu();
    }

    /**
     * Metodi tarkistaa, onko peli päättynyt.
     *
     * @return true jos toinen pelaaja on hävinnyt, false muuten
     */
    public boolean onkoPeliPaattynyt() {
        if (onkoHavinnyt(lauta1) || onkoHavinnyt(lauta2)) {
            return true;
        }
        return false;
    }

    /**
     * Metodi vaihtaa pelattavan laudan. Vain pelivuorossa olevan laudan ruutuja
     * voi ampua.
     */
    public void vaihdaPelattava() {
        if (this.pelattava == 1) {
            this.pelattava = 2;
        } else {
            this.pelattava = 1;
        }
    }

}
