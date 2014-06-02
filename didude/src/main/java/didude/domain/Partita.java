package didude.domain;

/**
 * Represents a single match of the game.
 */
public class Partita {

    private Boolean finita;

    private Mappa mappa;

    private Partita() {
    }

    static Partita nuovaPartita(Integer dimensioneMappa) {
        Partita nuovaPartita = new Partita();
        nuovaPartita.setFinita(Boolean.FALSE);
        Mappa mappa = Mappa.nuovaMappa(dimensioneMappa);
        nuovaPartita.setMappa(mappa);
        return nuovaPartita;
    }

    public Mappa mappa() {
        return mappa;
    }

    public Boolean finita() {
        return finita;
    }

    public void finisci() {
        setFinita(Boolean.TRUE);
    }

    private void setFinita(Boolean finita) {
        if (finita == null) {
            throw new IllegalArgumentException("Parameter 'finita' cannot be null.");
        }
        this.finita = finita;
    }

    private void setMappa(Mappa mappa) {
        if (mappa == null) {
            throw new IllegalArgumentException("Parameter 'mappa' cannot be null.");
        }
        this.mappa = mappa;
    }
}
