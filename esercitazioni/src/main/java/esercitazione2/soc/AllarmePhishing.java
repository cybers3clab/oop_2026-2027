package esercitazione2.soc;

public class AllarmePhishing extends Allarme {
    private final boolean credenzialiRubate;

    public AllarmePhishing(Evento evento, boolean credenzialiRubate) {
        super(evento);
        this.credenzialiRubate = credenzialiRubate;
    }

    @Override
    public int calcolaPriorita() {
        if (credenzialiRubate)
            return 8;
        return 3;
    }

    @Override
    public String azioneConsigliata() {
        if (credenzialiRubate)
            return "Forza il reset della password e avvisa l'utente";
        return "Segnala l'email e blocca il mittente";
    }
}
