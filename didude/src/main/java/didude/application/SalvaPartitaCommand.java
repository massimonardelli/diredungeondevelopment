package didude.application;

import didude.domain.Partita;

/**
 */
public class SalvaPartitaCommand {

    private Partita partita;

    public SalvaPartitaCommand(Partita aPartita) {
        this.partita = aPartita;
    }

    public Partita partita() {
        return partita;
    }
}
