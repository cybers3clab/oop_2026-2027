package esercitazione4;

public enum Stato {
    REGISTRATA(0),
    SMISTATA(30),
    IN_CONSEGNA(70),
    CONSEGNATA(100);

    private final int percentualeAvanzamento;

    private Stato(int percentualeAvanzamento) {
        this.percentualeAvanzamento = percentualeAvanzamento;
    }

    public int getPercentualeAvanzamento() {
        return percentualeAvanzamento;
    }

    public Stato avanza() {
         return switch (this) {
             case REGISTRATA -> Stato.SMISTATA;
             case SMISTATA -> Stato.IN_CONSEGNA;
             case IN_CONSEGNA -> Stato.CONSEGNATA;
             case CONSEGNATA -> throw new IllegalStateException("La spedizione è già stata consegnata!");
         };
    }

}
