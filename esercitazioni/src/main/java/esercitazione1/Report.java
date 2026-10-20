package esercitazione1;

public class Report {
    private String titolo;
    private String contenuto;

    public Report(String titolo, String contenuto) {
        this.titolo = titolo;
        this.contenuto = contenuto;
    }

    public String getContenuto() {return contenuto;}
    public void setContenuto(String contenuto){this.contenuto = contenuto;}
    public String getTitolo() {return titolo;}
    public void setTitolo(String titolo) {this.titolo = titolo;}
}
