package paatti.logiikka;

import java.util.List;

public class Laiva {
    
    private boolean tuhoutunut;
    private List<Ruutu> ruudut;

    public Laiva(List<Ruutu> ruudut) {
        this.ruudut = ruudut;
        this.tuhoutunut = false;
    }

    public boolean isTuhoutunut() {
        return tuhoutunut;
    }

    public void setOnEhja(boolean tuhoutunut) {
        this.tuhoutunut = tuhoutunut;
    }

}
