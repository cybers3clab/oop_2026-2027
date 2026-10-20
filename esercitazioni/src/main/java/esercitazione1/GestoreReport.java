package esercitazione1;

public class GestoreReport {

    public static void main(String[] args) {
        Report r1 = new Report("R1", "C1");
        IO.println("Titolo: " + r1.getTitolo() + "; Contenuto: " + r1.getContenuto());

        // Traccia: crea due report che condividono gli stessi dati
        Report r2 = r1;

        // Traccia: crea inoltre due array di Report di 3 elementi che condividono gli stessi Report (2 all'inizio)
        Report[] listaReport = new Report[3];
        listaReport[0] = r1;
        listaReport[1] = r2;
        Report[] listaReport2 = listaReport;


        // 1. Cosa succede se modifico il contenuto di uno dei due report?
        r2.setContenuto("C2");
        IO.println(r1.getContenuto());

        // 2. Cosa succede se modifico uno degli elementi di un array?
        listaReport[0].setContenuto("C10");
        listaReport[0].setTitolo("T10");
        IO.println(listaReport2[0].getContenuto()); // sto stampando listaReport2, ma ho aggiunto l'elemento a listaReport

        // 3. Cosa succede se ad un dei due array aggiungo un terzo report?
        Report r3 = new Report("R3", "C3");
        listaReport2[2] = r3;
        IO.println(listaReport[2].getContenuto()); // sto stampando listaReport, ma ho aggiunto l'elemento a listaReport2
    }
}
