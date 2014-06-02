package didude.domainUseCases;

import didude.domain.Casella;
import didude.domain.Gioco;
import didude.domain.Mappa;
import didude.domain.Partita;

/**
 * Test for use cases performed by a player.
 */
public class GiocatoreTest {

    public static void main(String[] args) {
        GiocatoreTest giocatoreTest = new GiocatoreTest();
        giocatoreTest.testIniziaPartita();
        giocatoreTest.testSalvaPartita();
        giocatoreTest.testCaricaPartita();
        giocatoreTest.testFiniscePartita();
        giocatoreTest.testCostruisceCostruzioneSuCasella();
    }

    void testIniziaPartita() {
        Gioco gioco = Gioco.instance;
        Integer dimensioneMappa = 10;
        Partita nuovaPartita = gioco.nuovaPartita(dimensioneMappa);
        if (nuovaPartita == null) throw new AssertionError();
    }

    void testSalvaPartita() {
        Gioco gioco = Gioco.instance;
        Integer dimensioneMappa = 10;
        Partita nuovaPartita = gioco.nuovaPartita(dimensioneMappa);
        gioco.salvaPartita(nuovaPartita);
    }

    void testCaricaPartita() {
        Gioco gioco = Gioco.instance;
        Integer dimensioneMappa = 10;
        Partita nuovaPartita = gioco.nuovaPartita(dimensioneMappa);
        gioco.salvaPartita(nuovaPartita);
        Partita partitaCaricata = gioco.caricaPartita();
        if (nuovaPartita != partitaCaricata) throw new AssertionError();
    }

    void testFiniscePartita() {
        Gioco gioco = Gioco.instance;
        Integer dimensioneMappa = 10;
        Partita partita = gioco.nuovaPartita(dimensioneMappa);
        partita.finisci();
        Boolean finita = partita.finita();
        if (!finita) throw new AssertionError();
    }

    void testCostruisceCostruzioneSuCasella() {
        Gioco gioco = Gioco.instance;
        Integer dimensioneMappa = 10;
        Partita partita = gioco.nuovaPartita(dimensioneMappa);
        Mappa mappa = partita.mappa();
        Casella casella_0_0 = mappa.casella(0, 0);
        casella_0_0.posizionaSopraUnaCostruzione();
    }

}
