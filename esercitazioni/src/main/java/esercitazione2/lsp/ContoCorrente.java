package esercitazione2.lsp;

public class ContoCorrente {
    protected double saldo;

    public ContoCorrente(double saldoIniziale) {
        this.saldo = saldoIniziale;
    }

    // Contratto: il prelievo riduce il saldo dell'importo richiesto, se ci sono fondi sufficienti.
    void preleva(double importo) {
        if (importo > saldo) {
            IO.println("Fondi insufficienti");
            System.exit(0);
        }
        saldo -= importo;
    }

    double getSaldo() {
        return saldo;
    }
}
