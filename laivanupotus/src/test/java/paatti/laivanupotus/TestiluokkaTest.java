package paatti.laivanupotus;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestiluokkaTest {

    @Test
    public void testiluokanKonstruktoriToimii() {
        Testiluokka testi = new Testiluokka();
        assertEquals(1, testi.getTestiarvo());
    }
}
