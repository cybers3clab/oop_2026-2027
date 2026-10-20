package esercitazione2.soc;

public class AllarmeBackdoor extends AllarmeMalware {
    private final boolean accessoRemotoGiaUsato;

    public AllarmeBackdoor(Evento evento, String processoSospetto, boolean accessoRemotoGiaUsato) {
        super(evento, processoSospetto);
        this.accessoRemotoGiaUsato = accessoRemotoGiaUsato;
    }

    @Override
    public int calcolaPriorita() {
        return accessoRemotoGiaUsato ? 10 : 7;
    }
}
