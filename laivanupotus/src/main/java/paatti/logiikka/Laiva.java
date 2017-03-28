package paatti.logiikka;

import java.util.ArrayList;
import java.util.List;

public class Laiva {

    private boolean tuhoutunut;
    private List<Ruutu> ruudut;

    public Laiva(List<Ruutu> laivanRuudut) {
        this.ruudut = laivanRuudut;
        this.tuhoutunut = false;
    }

    public boolean isTuhoutunut() {
        return tuhoutunut;
    }

    public void setTuhoutunut(boolean tuhoutunut) {
        this.tuhoutunut = tuhoutunut;
    }

    public List<Ruutu> getRuudut() {
        return ruudut;
    }

    public void tarkistaOnkoTuhoutunut() {
        int tuhoutuneet = 0;
        for (Ruutu ruutu : ruudut) {
            if (ruutu.isTuhoutunut()) {
                tuhoutuneet++;
            }
        }
        if (tuhoutuneet == ruudut.size()) {
            this.setTuhoutunut(true);
        }
    }

    @Override
    public String toString() {
        String osat = "";
        for (int i = 0; i < ruudut.size(); i++) {
            osat += ruudut.get(i) + " ";
        }
        return osat + "tuhoutunut:" + this.isTuhoutunut();
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
        
        return this.tuhoutunut == verrattava.tuhoutunut 
                && this.getRuudut() == verrattava.getRuudut();
    }

}
