package didude.domain;

/**
 * Represents the whole game.
 */
public class Gioco {

    public static final Gioco instance = new Gioco();

    private Partita partitaCorrente;

    private Gioco() {
    }

    public Partita nuovaPartita(Integer dimensioneMappa) {
        Partita nuovaPartita = Partita.nuovaPartita(dimensioneMappa);
        return nuovaPartita;
    }

    public void salvaPartita(Partita aPartita) {
        if (aPartita == null) {
            throw new IllegalArgumentException("Parameter 'aPartita' cannot be null.");
        }
        partitaCorrente = aPartita;
    }

    public Partita caricaPartita() {
        return partitaCorrente;
    }

}
