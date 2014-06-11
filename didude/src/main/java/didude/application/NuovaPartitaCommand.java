package didude.application;

/**
 */
public class NuovaPartitaCommand {

    private Integer dimensioneMappa;

    public NuovaPartitaCommand(Integer aDimensioneMappa) {
        dimensioneMappa = aDimensioneMappa;
    }

    public Integer dimensioneMappa() {
        return dimensioneMappa;
    }
}
