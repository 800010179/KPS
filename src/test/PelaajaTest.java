package test;

import kivipaperisakset.Pelaaja;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PelaajaTest {

        @Test
        void pelaajanValinta() {
            Pelaaja pelaaja = new Pelaaja();
            String valinta = pelaaja.pelaajanValinta();
            assertTrue(valinta.equals("kivi") || valinta.equals("paperi") || valinta.equals("sakset"));
        }

        @Test
        void lisaaVoitto() {
            Pelaaja pelaaja = new Pelaaja();
            pelaaja.lisaaVoitto();
            assertEquals(1, pelaaja.getVoitot());
        }
}