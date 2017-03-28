package paatti.logiikka;

public class Ruutu {

    private int x;
    private int y;
    private boolean sisaltaaLaivan;
    private boolean tuhoutunut;
    private boolean ammuttu;

    public Ruutu(int x, int y) {
        this.x = x;
        this.y = y;
        this.sisaltaaLaivan = false;
        this.tuhoutunut = false;
        this.ammuttu = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isSisaltaaLaivan() {
        return sisaltaaLaivan;
    }

    public void setSisaltaaLaivan(boolean sisaltaaLaivan) {
        this.sisaltaaLaivan = sisaltaaLaivan;
    }

    public boolean isTuhoutunut() {
        return tuhoutunut;
    }

    public void setTuhoutunut(boolean tuhoutunut) {
        this.tuhoutunut = tuhoutunut;
    }

    public boolean isAmmuttu() {
        return ammuttu;
    }

    public void setAmmuttu(boolean ammuttu) {
        this.ammuttu = ammuttu;
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
                && this.isSisaltaaLaivan() == verrattava.isSisaltaaLaivan()
                && this.isAmmuttu() == verrattava.isAmmuttu()
                && this.isTuhoutunut() == verrattava.isTuhoutunut();
    }

}
