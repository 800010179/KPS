package kivipaperisakset;

/**
 * @author Perttu Harvala + Ira Dook
 * Kivi paperi sakset pelin pelaaja.
 */
public class Pelaaja {

    private int voitot;

    /**
     * Valitsee pelaajan valinnaksi satunnaisesti kiven, paperin tai sakset.
     *
     * @return Pelaajan valinta.
     */
    public String pelaajanValinta() {
        int c = (int) (Math.random() * 3);
        return switch (c) {
            case 0 -> "kivi";
            case 1 -> "paperi";
            case 2 -> "sakset";
            default -> "";
        };
    }

    /**
     * Kasvattaa pelaajan voittojen lukumäärää yhdellä.
     */
    public void lisaaVoitto() {
        voitot++;
    }

    /**
     * Palauttaa pelaajan voittojen lukumäärän.
     *
     * @return Pelaajan voittojen lukumäärä.
     */
    public int getVoitot() {
        return voitot;
    }
}
