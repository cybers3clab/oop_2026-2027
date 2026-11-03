package esercitazione4;

public class SpedizioneFrigo extends SpedizioneAbstract{
    private final int temperatura;

    public SpedizioneFrigo(Codice codice, int peso, Dimensione dimensioni, int temperatura) {
        super(codice, peso, dimensioni);
        this.temperatura = temperatura;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\ttemperatura=" + this.temperatura;
    }

    @Override
    public double costo() {
        return super.costo() + 12.0 + (this.temperatura < -10 ? 5.0 : 0.0);
    }
}
