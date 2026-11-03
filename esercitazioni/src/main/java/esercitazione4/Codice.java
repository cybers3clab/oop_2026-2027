package esercitazione4;

public record Codice(String codice) {

    public Codice{
        if (codice == null || codice.isEmpty() || codice.length() > 12) {
            throw new IllegalArgumentException("Codice non valido");
        }
    }
}
