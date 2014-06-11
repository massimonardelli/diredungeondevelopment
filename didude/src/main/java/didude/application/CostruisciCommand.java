package didude.application;

import didude.domain.Partita;

/**
 */
public class CostruisciCommand {

    private Partita partita;

    private Integer row;

    private Integer column;

    public CostruisciCommand(Partita aPartita, Integer aRow, Integer aColumn) {
        this.partita = aPartita;
        this.row = aRow;
        this.column = aColumn;
    }

    public Partita partita() {
        return partita;
    }

    public Integer row() {
        return row;
    }

    public Integer column() {
        return column;
    }
}
