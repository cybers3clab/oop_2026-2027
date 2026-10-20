package esercitazione1;

public final class Somma {

    private final int[] lista;

    public Somma(int[] lista) {this.lista = lista;}
    public int[] getLista() {return this.lista;}

    public int somma() {
        int somma = 0;
        for (int x : this.lista)
            somma += x;
        return somma;
    }

    public int sommaAbsVal() {
        for (int i = 0; i < this.lista.length; ++i)
            this.lista[i] =  Math.abs(this.lista[i]);
        return somma();
    }

    public static void main(String[] args) {
        int[] lista = {-5, -3, -2};
        Somma somma = new Somma(lista);
        System.out.println(somma.sommaAbsVal());
        System.out.println(somma.somma());
    }
}
