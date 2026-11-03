package esercitazione4;

import java.util.Objects;

public abstract class SpedizioneAbstract implements Spedizione{
    protected final Codice codice;
    protected final int peso;
    protected final Dimensione dimensioni;
    protected Stato stato;

    public SpedizioneAbstract(Codice codice, int peso, Dimensione dimensioni) {
        if (codice == null || dimensioni == null || peso <= 0 || peso > 30000.0)
            throw new IllegalArgumentException("Spedizione non valida");

        this.codice = codice;
        this.peso = peso;
        this.dimensioni = dimensioni;
        this.stato = Stato.REGISTRATA;
    }

    public Dimensione getDimensioni() {
        return dimensioni;
    }

    @Override
    public Stato statoSpedizione() {
        return stato;
    }

    @Override
    public Codice codiceSpedizione() {
        return codice;
    }

    @Override
    public int pesoSpedizione() {
        return peso;
    }

    @Override
    public Stato avanza() {
        this.stato = this.stato.avanza();
        return this.stato;
    }

    @Override
    public String toString() {
        return "Spedizione: " + codice.codice() +
                "\n\tpesoSpedizione=" + peso +
                "\n\t" + dimensioni +
                "\n\tstatoSpedizione=" + stato;
    }

    @Override
    public final boolean equals(Object o) {
        if (o == this)
            return true;
        if (o == null || o.getClass() != this.getClass())
            return false;
        Spedizione spedizione = (Spedizione) o;
        return this.codice.equals(spedizione.codiceSpedizione());
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(this.codice);
    }
}
