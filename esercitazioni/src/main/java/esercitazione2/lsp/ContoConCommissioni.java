package esercitazione2.lsp;

public class ContoConCommissioni extends ContoCorrente {
    private static final double percentuale = 0.1;

    public ContoConCommissioni(double saldoIniziale) {
        super(saldoIniziale);
    }

    // VIOLAZIONE LSP:
    // rafforza la precondizione (rifiuta prelievi che il supertipo avrebbe accettato)
    // altera la postcondizione (scala più soldi di quanti richiesti, applicando una commissione)
    // lancia un'eccezione che il supertipo non si aspetta
    @Override
    void preleva(double importo) {
        double commissione = importo * ContoConCommissioni.percentuale;
        if (importo + commissione > saldo) {
            throw new IllegalArgumentException("Fondi insufficienti");
        }
        saldo -= (importo + commissione);
        if (saldo <= 1) {
            throw new RuntimeException("Sei povero");
        }
    }
}
