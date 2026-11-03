package esercitazione4;

import java.util.Objects;
import java.util.regex.Pattern;

public class Veicolo {
    static Pattern targaPattern = Pattern.compile("[A-Z]{2}\\d{3}[A-Z]{2}");

    private final String targa;
    private final double portataMassima;
    private double caricoAttuale;

    public Veicolo(String targa, double portataMassima) {
        if (targa == null || portataMassima <= 0 || portataMassima > 1500000.0)
            throw new IllegalArgumentException("Veicolo non valido");
        if (!targaPattern.matcher(targa).matches())
            throw new IllegalArgumentException("Targa non valida");

        this.targa = targa;
        this.portataMassima = portataMassima;
        this.caricoAttuale = 0.0;
    }

    public String getTarga() {
        return targa;
    }

    public double getPortataMassima() {
        return portataMassima;
    }

    public double getCaricoAttuale() {
        return caricoAttuale;
    }

    @Override
    public String toString() {
        return "Veicolo{" +
                "targa='" + targa + '\'' +
                ", portataMassima=" + portataMassima +
                ", caricoAttuale=" + caricoAttuale +
                '}';
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        Veicolo veicolo = (Veicolo) o;
        return this.targa.equals(veicolo.targa);
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(targa);
    }

    public boolean carica(Spedizione spedizione) {
        if (spedizione == null)
            throw new IllegalArgumentException("Impossibile caricare spedizione");

        double nuovoCarico = this.caricoAttuale + spedizione.pesoSpedizione();
        if (nuovoCarico > this.portataMassima)
            return false;
        this.caricoAttuale = nuovoCarico;
        return true;
    }
}
