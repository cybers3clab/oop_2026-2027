package esercitazione4;

public record Dimensione(int lunghezza, int altezza, int larghezza) {

    public Dimensione {
        if (lunghezza < 1 || altezza < 1 || larghezza < 1 || lunghezza + altezza + larghezza > 200) {
            throw new IllegalArgumentException("Dimensioni non valide");
        }
    }

    public int calcolaVolume() {
        return this.lunghezza * this.altezza * this.larghezza;
    }
}
