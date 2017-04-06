package paatti.logiikka;

/**
 * Laiva pitää sisällään määrällisen tiedon sen ehjistä osista, sekä tiedon siitä,
 * onko laiva kokonaisuudessaan ehjä vai tuhoutunut.
 */

public class Laiva {

    private int ehjatOsat;
    private boolean tuhoutunut;

    /**
     * Laivan konstruktori, joka määrittää laivan koon.
     * 
     * @param koko Laivan koko eli siihen liittyvien ruutujen määrä
     */
    public Laiva(int koko) {
        this.ehjatOsat = koko;
    }

    public int getEhjatOsat() {
        return ehjatOsat;
    }

    
    public boolean getTuhoutunut() {
        return tuhoutunut;
    }

    /**
     * Vähentää laivan ehjien osien määrä yhdellä, ja mikäli ehjien osien
     * määrä on 0, merkitsee laivan tuhoutuneeksi.
     */
    public void ammu() {
        ehjatOsat--;
        if (ehjatOsat == 0) {
            tuhoutunut = true;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        Laiva verrattava = (Laiva) o;

        return this.ehjatOsat == verrattava.ehjatOsat
                && this.tuhoutunut == verrattava.tuhoutunut;
    }
}
