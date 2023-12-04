package test;

import kivipaperisakset.Peli;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PeliTest {
    private Peli peli;

    @BeforeEach
    public void alusta() {
        peli = new Peli();
    }

    @Test
    public void testValitseVoittaja() {
        // Pelaaja 1 voittaa
        peli.valitseVoittaja("kivi", "sakset");
        assertEquals(1, peli.getP1Voitot());
        assertEquals(0, peli.getP2Voitot());

        // Pelaaja 2 voittaa
        peli.valitseVoittaja("sakset", "kivi");
        assertEquals(1, peli.getP1Voitot());
        assertEquals(1, peli.getP2Voitot());

        // Tasapeli
        peli.valitseVoittaja("paperi", "paperi");
        assertEquals(1, peli.getTasapelit());
    }
    @Test
    public void testPelaaPeli() {
        // Pelattujen erien tulisi kasvaa ainakin yhdellä
        int pelatutErat = 0;
        peli.pelaaPeli();
        assertTrue(peli.getPelatutPelit() > pelatutErat);
  }
}