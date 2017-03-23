package paatti.logiikka;

import java.util.ArrayList;
import java.util.List;

public class Laiva {

    private boolean tuhoutunut;
    private List<Ruutu> ruudut;

    public Laiva() {
        this.ruudut = new ArrayList<>();
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

    public void lisaaRuutu(Ruutu ruutu) {
        this.ruudut.add(ruutu);
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
        return osat + "tuhoutunut: " + this.isTuhoutunut();
    }

}
