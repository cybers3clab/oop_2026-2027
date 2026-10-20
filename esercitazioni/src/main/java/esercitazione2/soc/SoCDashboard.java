package esercitazione2.soc;

import java.time.Instant;

public class SoCDashboard {
    public static void main(String[] args) {

        Evento sePhi =  new Evento("Email da portale bancario", "mail-intesa.example", Instant.now());
        Evento seRan =  new Evento("File cifrati rilevati", "10.0.4.12", Instant.now());
        Evento seBac =  new Evento("Processo in ascolto su porta non standard", "10.0.4.30", Instant.now());

        Allarme[] coda = new Allarme[3];
        coda[0] = new AllarmeRansomware(seRan, "svchost_fake.exe", 240);
        coda[1] = new AllarmePhishing(sePhi, true);
        coda[2] = new AllarmeBackdoor(seBac, "shell.exe", true);

        ordinaPerPriorita(coda);

       IO.println("\n=== Coda allarmi SOC (ordinata per priorità) ===");
        for (Allarme a : coda) {
            IO.println(a); // toString() chiama la versione REALE di calcolaPriorita() e azioneConsigliata()
        }
    }

    // Selection sort decrescente per priorità.
    private static void ordinaPerPriorita(Allarme[] coda) {
        for (int i = 0; i < coda.length - 1; i++) {
            int indiceMassimo = i;
            for (int j = i + 1; j < coda.length; j++) {
                if (coda[j].calcolaPriorita() > coda[indiceMassimo].calcolaPriorita()) {
                    indiceMassimo = j;
                }
            }
            Allarme temp = coda[i];
            coda[i] = coda[indiceMassimo];
            coda[indiceMassimo] = temp;
        }
    }
}
