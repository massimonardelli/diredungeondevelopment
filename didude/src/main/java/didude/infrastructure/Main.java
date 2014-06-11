package didude.infrastructure;

import didude.application.CostruisciCommand;
import didude.application.GiocatoreCommandsHandler;
import didude.application.NuovaPartitaCommand;
import didude.application.SalvaPartitaCommand;
import didude.domain.Partita;

import java.util.Scanner;

/**
 */
public class Main {

    private static final String EXIT_CMD = "exit";
    private static final String NEW_CMD = "new";
    private static final String SAVE_CMD = "save";
    private static final String LOAD_CMD = "load";
    private static final String BUILD_CMD = "build";

    private static final String ERROR_MSG = "Nonsense.";

    public static void main(String[] args) {
        GiocatoreCommandsHandler handler = new GiocatoreCommandsHandler();
        Partita partita = null;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase(EXIT_CMD)) {
                System.exit(0);
            } else if (line.startsWith(NEW_CMD)) {
                String[] words = line.split(" ");
                Integer dimensioneMappa = Integer.valueOf(words[1]);
                NuovaPartitaCommand nuovaPartitaCommand = new NuovaPartitaCommand(dimensioneMappa);
                partita = handler.handle(nuovaPartitaCommand);
            } else if (line.equalsIgnoreCase(SAVE_CMD)) {
                SalvaPartitaCommand salvaPartitaCommand = new SalvaPartitaCommand(partita);
                handler.handle(salvaPartitaCommand);
            } else if (line.equalsIgnoreCase(LOAD_CMD)) {
                partita = handler.handle();
            } else if (line.startsWith(BUILD_CMD)) {
                String[] words = line.split(" ");
                Integer row = Integer.valueOf(words[1]);
                Integer column = Integer.valueOf(words[2]);
                CostruisciCommand costruisciCommand = new CostruisciCommand(partita, row, column);
                handler.handle(costruisciCommand);
            } else {
                System.out.println(ERROR_MSG);
            }
        }
    }

}
