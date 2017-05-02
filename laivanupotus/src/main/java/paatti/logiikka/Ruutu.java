package paatti.logiikka;

/**
 * Ruutu kuvaa yhtä pelilaudan ruutua ja pitää sisällään tiedon koordinaateista,
 * mahdollisesta laivasta, sekä siitä, onko ruutua ammuttu tai onko se
 * tuhoutunut.
 */
public class Ruutu {

    private int x;
    private int y;
    private boolean ammuttu;
    private boolean estetty;
    private Laiva laiva;

    /**
     * Ruudun konstruktori. Kun ruutu alustetaan, asetetaan false ammuttu- ja
     * tuhoutunut muuttujiin. Mahdollinen laiva liitetään ruutuun jälkikäteen,
     * joten se alustetaan null-arvolla.
     *
     * @param x Ruudun x-koordinaatti
     * @param y Ruudun y-koordinaatti
     */
    public Ruutu(int x, int y) {
        this.x = x;
        this.y = y;
        this.estetty = false;
        this.ammuttu = false;
        this.laiva = null;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean getEstetty() {
        return estetty;
    }

    public void setEstetty(boolean estetty) {
        this.estetty = estetty;
    }

    public boolean getAmmuttu() {
        return ammuttu;
    }

    public void setAmmuttu(boolean ammuttu) {
        this.ammuttu = ammuttu;
    }

    public Laiva getLaiva() {
        return laiva;
    }

    public void setLaiva(Laiva laiva) {
        this.laiva = laiva;
    }

    @Override
    public String toString() {
        return "[" + this.x + ", " + this.y + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        Ruutu verrattava = (Ruutu) o;

        return this.getX() == verrattava.getX() && this.getY() == verrattava.getY()
                && this.getAmmuttu() == verrattava.getAmmuttu()
                && this.getEstetty()== verrattava.getEstetty()
                && this.getLaiva() == verrattava.getLaiva();
    }
}
