package esercitazione3;

import java.util.Arrays;

public class GestoreAzienda {

    public static void main(String[] args) {
        Bonus bonusNullo = (_) -> 0.0;
        Bonus bonusFisso = (_) -> 200.0;
        Bonus bonusAScaglioni = (valutazione) -> {
            if (valutazione.equals(Valutabile.ECCELLENTE))
                return 300.0;
            else if (valutazione.equals(Valutabile.BUONO))
                return 250.0;
            else if (valutazione.equals(Valutabile.SUFFICIENTE))
                return 220.0;
            return 0.0; // se il dipendente è Insufficiente
        };

        Dipendente[] dipendenti = new Dipendente[4];
        Dipendente d1 = new Dipendente("d1", Seniority.JUNIOR, 2, bonusNullo);
        Dipendente d2 = new Dipendente("d2", Seniority.SENIOR, 5, bonusFisso);
        Dipendente d3 = new Dipendente("d3", Seniority.JUNIOR, 2, bonusFisso);
        Dipendente d4 = new Dipendente("d4", Seniority.SENIOR, 7, bonusAScaglioni);
        dipendenti[0] = d1;
        dipendenti[1] = d2;
        dipendenti[2] = d3;
        dipendenti[3] = d4;

        // Array con soli dipendenti Eccellenti
        // Per creare l'array di dimensione giusta prima li conto tutti e poi li aggiungo
        int numeroDipendentiEccellenti = 0;
        for (Dipendente dipendente : dipendenti)
            if (dipendente.calcolaValutazione().equals(Valutabile.ECCELLENTE))
                numeroDipendentiEccellenti++;

        Dipendente[] dipendentiEccellenti = new Dipendente[numeroDipendentiEccellenti];
        int indice = 0;
        for (Dipendente dipendente : dipendenti)
            if (dipendente.calcolaValutazione().equals(Valutabile.ECCELLENTE)) {
                dipendentiEccellenti[indice] = dipendente;
                indice++;
            }

        // lambda expression per ordinare i dipendenti Eccellenti in basel allo stipendio totale decrescente
        Arrays.sort(dipendentiEccellenti,
                (dip1, dip2) -> Double.compare(dip2.calcolaStipendioTotale(), dip1.calcolaStipendioTotale()));

        IO.println("========== DIPENDENTI ECCELLENTI ==========\n");
        for (Dipendente d : dipendentiEccellenti) {
            System.out.println(d.dettaglio());
            System.out.println("---");
        }
    }
}
