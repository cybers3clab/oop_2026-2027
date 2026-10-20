package esercitazione2.lsp;

public class Main {
    public static void main(String[] args) {
        ContoCorrente cc = new ContoConCommissioni(200);
        cc.preleva(181.0);
        // Il client, basandosi sul contratto di ContoBancario, si aspetta che il saldo sia diminuito ESATTAMENTE di 100.0
        IO.println("Saldo atteso: saldoIniziale (200) - 100.0");
        IO.println("Saldo reale: " + cc.getSaldo());
    }
}
