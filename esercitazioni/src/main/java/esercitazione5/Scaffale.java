package esercitazione5;

public class Scaffale {
    private int qtaProdotto;
    private final int id;

    public Scaffale(int qtaProdotto, int id) {
        if (qtaProdotto < 0)
            throw new IllegalArgumentException("La quantità di prodotto non può essere negativa");
        this.qtaProdotto = qtaProdotto;
        this.id = id;
    }

    public int getQtaProdotto() {
        return qtaProdotto;
    }

    public void setQtaProdotto(int qtaProdotto) {
        if (qtaProdotto < 0)
            throw new IllegalArgumentException("La quantità di prodotto non può essere negativa");
        this.qtaProdotto = qtaProdotto;
    }

    public int getId() {
        return this.id;
    }

    public final boolean equals(Object o) {
        if (o == this)
            return true;
        if (o == null || o.getClass() != this.getClass())
            return false;
        Scaffale scaffale = (Scaffale) o;
        return this.id == scaffale.id;
    }

    public final int hashCode() {
        return Integer.valueOf(this.id).hashCode();
    }

    public String toString() {
        return String.format("Scaffale con id: [%d]\n\tQuantità: %d", this.id, this.qtaProdotto);
    }

}
