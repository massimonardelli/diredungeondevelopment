package didude.domain;

/**
 * The map in which the match takes place.
 */
public class Mappa {

    private Casella[][] caselle;

    private Mappa() {
    }

    static Mappa nuovaMappa(Integer dimensione) {
        if (dimensione == null) {
            throw new IllegalArgumentException("Parameter 'dimensione' cannot be null.");
        }
        if (dimensione < 0) {
            throw new IllegalArgumentException("Parameter 'dimensione' cannot be less than '0'.");
        }
        Mappa mappa = new Mappa();
        Casella[][] caselle = new Casella[dimensione][dimensione];
        for (Casella[] riga : caselle) {
            for (int j = 0; j < riga.length; j++) {
                riga[j] = Casella.creaCasella();
            }
        }
        mappa.setCaselle(caselle);
        return mappa;
    }

    public Casella casella(Integer row, Integer column) {
        if (row == null) {
            throw new IllegalArgumentException("Parameter 'row' cannot be null.");
        }
        if (row < 0) {
            throw new IllegalArgumentException("Parameter 'row' cannot be less than '0'.");
        }
        if (row >= caselle.length) {
            throw new IllegalArgumentException("Parameter 'row' cannot be greater than map's row length.");
        }
        if (column == null) {
            throw new IllegalArgumentException("Parameter 'column' cannot be null.");
        }
        if (column < 0) {
            throw new IllegalArgumentException("Parameter 'column' cannot be less than '0'.");
        }
        if (column >= caselle[0].length) {
            throw new IllegalArgumentException("Parameter 'column' cannot be greater than map's column length.");
        }
        Casella casella = caselle[row][column];
        return casella;
    }

    private void setCaselle(Casella[][] caselle) {
        if (caselle == null) {
            throw new IllegalArgumentException("Parameter 'caselle' cannot be null.");
        }
        for (Casella[] riga : caselle) {
            for (Casella casella : riga) {
                if (casella == null) {
                    throw new IllegalArgumentException("Parameter 'caselle' cannot contain null values.");
                }
            }
        }
        Casella[][] caselleClone = caselle.clone();
        this.caselle = caselleClone;
    }

}
