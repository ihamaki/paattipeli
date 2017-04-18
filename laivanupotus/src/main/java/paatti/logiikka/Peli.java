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
    private Lauta pelattava;
    private boolean peliPaattynyt;

    public Peli(int koko) {
        this.lauta1 = new Lauta(koko);
        this.lauta2 = new Lauta(koko);
        this.pelattava = this.lauta1;
        this.peliPaattynyt = false;
    }

    public Lauta getLauta1() {
        return lauta1;
    }

    public Lauta getLauta2() {
        return lauta2;
    }

    public Lauta getPelattava() {
        return pelattava;
    }

    public void pelaa() {
        this.pelattava.lisaaLaivat();
    }

    public void ammu(Lauta lauta, int x, int y) {
        lauta.ammu(x, y);
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

    public boolean onkoPeliPaattynyt() {
        if (onkoHavinnyt(lauta1) || onkoHavinnyt(lauta2)) {
            return true;
        }

        return false;
    }

    public void vaihdaPelattava() {
        if (this.pelattava == lauta1) {
            this.pelattava = lauta2;
        } else {
            this.pelattava = lauta1;
        }
    }

}
