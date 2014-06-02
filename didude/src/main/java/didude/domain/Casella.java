package didude.domain;

/**
 * A square-like piece of the grid that compose the {@link Mappa}.
 */
public class Casella {

    private Boolean haSopraUnaCostruzione;

    private Casella() {
    }

    static Casella creaCasella() {
        Casella casella = new Casella();
        casella.setHaSopraUnaCostruzione(Boolean.FALSE);
        return casella;
    }

    public Boolean haSopraUnaCostruzione() {
        return haSopraUnaCostruzione;
    }

    public void posizionaSopraUnaCostruzione() throws CasellaGiàOccupata {
        if (haSopraUnaCostruzione()) {
            throw new CasellaGiàOccupata();
        }
        setHaSopraUnaCostruzione(Boolean.TRUE);
    }

    private void setHaSopraUnaCostruzione(Boolean haSopraUnaCostruzione) {
        if (haSopraUnaCostruzione == null) {
            throw new IllegalArgumentException("Parameter 'haSopraUnaCostruzione' cannot be null.");
        }
        this.haSopraUnaCostruzione = haSopraUnaCostruzione;
    }

}
