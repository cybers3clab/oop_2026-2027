package esercitazione2.soc;

public abstract class Allarme {
    private static int contatore = 0;

    protected final int id;
    protected final Evento evento;

    public Allarme(Evento evento) {
        this.id = contatore++;
        this.evento = evento.processa();
    }

    public int getId() {
        return this.id;
    }

    public Evento getEvento() {
        return this.evento.processa();
    }

    // Ogni tipo di allarme calcola la priorità in modo diverso
    public abstract int calcolaPriorita();

    // Ogni tipo di allarme suggerisce un'azione diversa
    public abstract String azioneConsigliata();

    @Override
    public String toString() {
        return String.format("[#%d] %s da <%s>:(%s), priorità %d --> %s",
                id, getClass().getSimpleName(),
                evento.sorgente(), evento.descrizione(),
                calcolaPriorita(), azioneConsigliata());
    }

    public final boolean equals(Object a) {
        if (a == this) return true;
        if (a == null || this.getClass() != a.getClass()) return false;
        Allarme b = (Allarme) a;
        return this.id == b.id;
    }

    public final int hashCode() {
        int hash = 7;
        hash = 31 * hash + id;
        return hash;
    }
}
