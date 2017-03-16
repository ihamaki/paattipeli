package paatti.laivanupotus;

public class Testiluokka {
    private int testiarvo;

    public Testiluokka() {
        this.testiarvo = 1;
    }

    public int getTestiarvo() {
        return testiarvo;
    }

    public void setTestiarvo(int testiarvo) {
        this.testiarvo = testiarvo;
    }

    @Override
    public String toString() {
        return "" + this.testiarvo;
    }
}
