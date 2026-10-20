package esercitazione1;

public class TestGC {
    public static void main(String[] args) {
        for (int i = 0; i < 1_000_000; i++) {
            byte[] temp = new byte[10_000]; // diventa subito spazzatura
        }
    }
}