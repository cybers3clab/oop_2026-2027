package esercitazione2.soc;

import java.time.Instant;

public record Evento(String descrizione, String sorgente, Instant timestamp) {
    //N.B: non serve ridefinire il getter per timestamp in quanto Instant è un tipo immutabile

    public Evento {
        if (sorgente == null || sorgente.isBlank()) {
            throw new IllegalArgumentException("La sorgente non può essere vuota");
        }
        if (descrizione == null || descrizione.isBlank()) {
            throw new IllegalArgumentException("La descrizione non può essere vuota");
        }
    }

    public Evento processa() {
        return new Evento(descrizione, sorgente, timestamp);
    }
}
