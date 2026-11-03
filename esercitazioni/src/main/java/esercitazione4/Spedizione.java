package esercitazione4;

public interface Spedizione extends Comparable<Spedizione> {
    int pesoSpedizione();
    Codice codiceSpedizione();
    Stato statoSpedizione();

    Stato avanza();

    default double costo() {
        return 4.0 + Math.ceil(this.pesoSpedizione() / 1000.0);
    }

    default int compareTo(Spedizione spedizione) {
        int confrontoPeso = Integer.compare(this.pesoSpedizione(), spedizione.pesoSpedizione());
        if (confrontoPeso > 0)
            return -1;
        if (confrontoPeso < 0)
            return 1;
        return this.codiceSpedizione().codice().compareTo(spedizione.codiceSpedizione().codice());
    }
}
