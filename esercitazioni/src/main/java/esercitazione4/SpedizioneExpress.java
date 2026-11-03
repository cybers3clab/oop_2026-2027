package esercitazione4;

public class SpedizioneExpress extends SpedizioneAbstract{
    private final int numeroPacchi;

    public SpedizioneExpress(Codice codice, int peso, Dimensione dimensione,  int numeroPacchi) {
        super(codice, peso, dimensione);
        if (numeroPacchi < 1)
            throw new IllegalArgumentException("SpedizioneExpress non valida");
        this.numeroPacchi = numeroPacchi;
    }

    public int getNumeroPacchi() {
        return this.numeroPacchi;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\tnumeroPacchi=" + this.numeroPacchi;
    }

    @Override
    public double costo() {
        return super.costo() + 6.0 + 2*this.numeroPacchi;
    }
}
