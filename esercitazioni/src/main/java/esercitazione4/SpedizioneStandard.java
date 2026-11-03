package esercitazione4;

public class SpedizioneStandard extends SpedizioneAbstract{
    private final boolean richiestaFirma;

    public SpedizioneStandard(Codice codice, int peso, Dimensione dimensioni, boolean richiestaFirma) {
        super(codice, peso, dimensioni);
        this.richiestaFirma = richiestaFirma;
    }

    public boolean isRichiestaFirma() {
        return richiestaFirma;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\tfirmaRichiesta=" + this.richiestaFirma;
    }

    @Override
    public double costo() {
        return super.costo() + (richiestaFirma ? 2.0 : 0.0);
    }
}
