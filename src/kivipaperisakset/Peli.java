package kivipaperisakset;

import java.util.Scanner;

/**
 * @author Perttu Harvala + Ira Dook
 * Kivi paperi sakset peli.
 */
public class Peli {

    private final Pelaaja p1;
    private final Pelaaja p2;
    private int pelatutPelit;
    private int tasapelit;
    private boolean peliLoppui;

    /**
     * Alustaa pelin ja kaksi pelaajaa.
     */
    public Peli() {
        p1 = new Pelaaja();
        p2 = new Pelaaja();
        pelatutPelit = 0;
        tasapelit = 0;
        peliLoppui = false;
    }
    /**
     * Pelaa peliä tekemällä satunnaisia valintoja pelaajille, kunnes jompikumpi pelaajista saa kolme voittoa.
     */
    public void pelaaPeli() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Erä: " + pelatutPelit + " =====================\n");
            System.out.println("Tasapelien lukumäärä: " + tasapelit + "\n");

            String p1Valinta = p1.pelaajanValinta();
            System.out.println("Pelaaja 1: " + p1Valinta + "\n\t Pelaaja 1:llä " + p1.getVoitot() + " voittoa.");

            String p2Valinta = p2.pelaajanValinta();
            System.out.println("Pelaaja 2: " + p2Valinta + "\n\t Pelaaja 2:lla " + p2.getVoitot() + " voittoa.");

            valitseVoittaja(p1Valinta, p2Valinta);

            pelatutPelit++;

            if (p1.getVoitot() >= 3 || p2.getVoitot() >= 3) {
                System.out.println("KOLME VOITTOA - PELI PÄÄTTYY");
                peliLoppui = true;
            }

            System.out.println();
        } while (!peliLoppui);

        scanner.close();
    }

    /**
     * Valitsee erän voittajan pelaajien valintojen perusteella.
     *
     * @param p1Valinta Pelaajan 1 valinta.
     * @param p2Valinta Pelaajan 2 valinta.
     */
    public void valitseVoittaja(String p1Valinta, String p2Valinta) {
        if (p1Valinta.equals(p2Valinta)) {
            tasapelit++;
            System.out.println("\n\t\t\t Tasapeli \n");
        } else if ((p1Valinta.equals("kivi") && p2Valinta.equals("sakset"))
                || (p1Valinta.equals("paperi") && p2Valinta.equals("kivi"))
                || (p1Valinta.equals("sakset") && p2Valinta.equals("paperi"))) {
            p1.lisaaVoitto();
            System.out.println("Pelaaja 1 voittaa");
        } else {
            p2.lisaaVoitto();
            System.out.println("Pelaaja 2 voittaa");
        }
    }

    /**
     * Palauttaa pelattujen erien lukumäärän.
     *
     * @return Pelattujen erien lukumäärä.
     */
    public int getPelatutPelit() {
        return pelatutPelit;
    }

    /**
     * Palauttaa tasapelien lukumäärän.
     *
     * @return Tasapelien lukumäärä.
     */
    public int getTasapelit() {
        return tasapelit;
    }

    /**
     * Palauttaa pelaajan 1 voittojen lukumäärän testaamista varten.
     *
     * @return Pelaajan 1 voittojen lukumäärä.
     */
    public int getP1Voitot() {
        return p1.getVoitot();
    }

    /**
     * Palauttaa pelaajan 2 voittojen lukumäärän testaamista varten.
     *
     * @return Pelaajan 2 voittojen lukumäärä.
     */
    public int getP2Voitot() {
        return p2.getVoitot();
    }
}
