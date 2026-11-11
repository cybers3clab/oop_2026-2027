package esercitazione5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Magazzino {
    private int qtaScaffali;
    private final String nome;
    private Scaffale[] scaffali;

    public Magazzino(int qtaScaffali, String nome) {
        if (qtaScaffali <= 0) {
            throw new IllegalArgumentException("Serve almeno uno scaffale");
        }
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Specificare un nome valido");
        }
        this.qtaScaffali = qtaScaffali;
        this.nome = nome;
        this.scaffali = new Scaffale[this.qtaScaffali];
    }

    public String getNome() {
        return nome;
    }

    public void setScaffali(Scaffale[] scaffali) {
        if (scaffali == null) {
            throw new IllegalArgumentException("Serve almeno un scaffale");
        }
        this.scaffali = scaffali.clone(); // copia
    }

    public int prelevaQuantitaProdotto(int posizioneScaffale, int qta) throws ScaffaleEsauritoException{
        if (posizioneScaffale < 0 || posizioneScaffale >= this.scaffali.length) {
            throw new IndexOutOfBoundsException("Posizione scaffale non valida");
        }
        if (qta <= 0 || this.scaffali[posizioneScaffale] == null || this.scaffali[posizioneScaffale].getQtaProdotto() - qta < 0) {
            throw new IllegalArgumentException(String.format("Non si può prelevare la quantità specifica dallo scaffale [%d]",posizioneScaffale));
        }

        int nuovaQta = this.scaffali[posizioneScaffale].getQtaProdotto() - qta;
        this.scaffali[posizioneScaffale].setQtaProdotto(nuovaQta);
        if (nuovaQta == 0) {
            throw new ScaffaleEsauritoException(String.format("Scaffale [%d] ESAURITO", posizioneScaffale));
        }
        return nuovaQta;
    }

    static void main(String[] args) {
        Scaffale[] scaffali = {
                new Scaffale(10,0),
                new Scaffale(20,1),
                new Scaffale(1,2),
                new Scaffale(5,3)
        };
        Magazzino magazzino = new Magazzino(4, "magazzino1");
        magazzino.setScaffali(scaffali);

        Scanner scanner = new Scanner(System.in);
        IO.println("========== " + magazzino.getNome() + " ==========");
        try{
            IO.print("Inserisci il numero (posizione) dello scaffale: ");
            int n = scanner.nextInt();

            IO.print("Inserisci la quantità di prodotto da prelevare: ");
            int qta = scanner.nextInt();
            int nuovaQta = magazzino.prelevaQuantitaProdotto(n, qta);
            IO.println(String.format("La nuova quantità di prodotto nello scaffale [%d] è: %d", n, nuovaQta));
        }
        catch (IndexOutOfBoundsException oobe) {
            IO.println("Scaffale non presente nel magazzino");
        }
        catch (InputMismatchException ime) {
            IO.println("Fornisci un numero");
        }
        catch (ScaffaleEsauritoException sve) {
            IO.println("Lo scaffale selezionato è ESAURITO");
        }
        catch (IllegalArgumentException e) {
            IO.println("Quantità specificata non valida");
        }
        finally {
            scanner.close();
        }
    }
}
