package esercitazione3;

public interface Valutabile {
    String ECCELLENTE = "Eccellente";
    String BUONO = "Buono";
    String SUFFICIENTE = "Sufficiente";
    String INSUFFICIENTE = "Insufficiente";

    int getNumeroProgetti();

    default String calcolaValutazione(){
        int numeroProgetti = getNumeroProgetti();
        if (numeroProgetti >= 5)
            return ECCELLENTE;
        else if (numeroProgetti > 3)
            return BUONO;
        else if (numeroProgetti > 2)
            return SUFFICIENTE;
        return INSUFFICIENTE;
    }

    default String dettaglio() {
        return "Valutazione: " + calcolaValutazione();
    }
}
