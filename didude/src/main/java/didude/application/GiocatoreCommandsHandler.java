package didude.application;

import didude.domain.Gioco;
import didude.domain.Partita;

/**
 * Handler of commands generated by a player.
 */
public class GiocatoreCommandsHandler {

    public Partita handle(NuovaPartitaCommand nuovaPartitaCommand) {
        Gioco gioco = Gioco.instance;
        Integer dimensioneMappa = nuovaPartitaCommand.dimensioneMappa();
        Partita nuovaPartita = gioco.nuovaPartita(dimensioneMappa);
        return nuovaPartita;
    }
}
