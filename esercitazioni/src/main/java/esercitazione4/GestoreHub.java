package esercitazione4;

public class GestoreHub {

    public static void operazioniCompletate(Stato statoSpedizione) {
        if (statoSpedizione == null)
            throw new IllegalArgumentException("Stato non valido");

        // switch istruzione con ":" SENZA break: le operazioni sono CUMULATIVE,
        // quindi ogni stato esegue la propria e poi prosegue in quelle degli stati precedenti
        switch (statoSpedizione) {
            case CONSEGNATA:
                IO.println("Acquisizione della conferma di ricezione");
            case IN_CONSEGNA:
                IO.println("Presa in carico da parte del corriere");
            case SMISTATA:
                IO.println("Instradamento al veicolo");
            case REGISTRATA:
                IO.println("Stampa dell'etichetta");
        }
    }

    public static void main(String[] args) {
        Spedizione standard = new SpedizioneStandard(new Codice("STD001"), 1500, new Dimensione(30, 20, 10), true);

        // Avanzamento dello stato e operazioni completate
        IO.println("\n=== Avanzamento di " + standard.codiceSpedizione().codice() + " ===");
        while (standard.statoSpedizione() != Stato.CONSEGNATA) {
            Stato stato = standard.statoSpedizione();
            IO.println("Stato: " + stato + " (" + stato.getPercentualeAvanzamento() + "%)");
            operazioniCompletate(stato);
            standard.avanza();
            IO.println();
        }
        IO.println("Stato: " + standard.statoSpedizione() + " (" + standard.statoSpedizione().getPercentualeAvanzamento() + "%)");
        operazioniCompletate(standard.statoSpedizione());
        IO.println();


        // Caricamento sul veicolo di un insieme di spedizioni
        Spedizione express = new SpedizioneExpress(new Codice("EXP001"), 12000, new Dimensione(60, 40, 40), 3);
        Spedizione frigo = new SpedizioneFrigo(new Codice("FRG001"), 800, new Dimensione(25, 25, 25), -18);
        Spedizione pesante = new SpedizioneStandard(new Codice("STD002"), 25000, new Dimensione(80, 60, 50), false);
        Spedizione[] spedizioni = {standard, express, frigo, pesante};

        IO.println("\n=== Caricamento veicolo ===");
        Veicolo furgone = new Veicolo("AB123CD", 20000);
        for (Spedizione s : spedizioni) {
            boolean caricata = furgone.carica(s);
            IO.println(s.codiceSpedizione().codice() + " caricata: " + caricata
                    + " (carico attuale " + furgone.getCaricoAttuale() + " / " + furgone.getPortataMassima() + ")");
        }
    }
}
