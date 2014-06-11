package didude.application;

import didude.domain.Partita;

/**
 */
public class FinisciPartitaCommand {

    private Partita partita;

    public FinisciPartitaCommand(Partita aPartita) {
        this.partita = aPartita;
    }

    public Partita partita() {
        return partita;
    }
}
