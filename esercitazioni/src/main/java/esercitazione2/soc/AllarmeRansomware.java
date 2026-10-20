package esercitazione2.soc;

public class AllarmeRansomware extends AllarmeMalware {
    private final int fileCifrati;

    public AllarmeRansomware(Evento evento, String processoSospetto, int fileCifrati) {
        super(evento, processoSospetto);
        this.fileCifrati = fileCifrati;
    }

    @Override
    public int calcolaPriorita() {
        return fileCifrati > 100 ? 10 : 7;
    }
}
