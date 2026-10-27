package esercitazione3;

public interface Retribuibile {
    double calcolaStipendioBase();
    double calcolaBonus();

    default double calcolaStipendioTotale() {
        return calcolaStipendioBase() + calcolaBonus();
    }

    default String dettaglio(){
        return calcolaStipendioTotale() + "€\n\tDi cui Bonus: " +  calcolaBonus() + "€";
    }
}
