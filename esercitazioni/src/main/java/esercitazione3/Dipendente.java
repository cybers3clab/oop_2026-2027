package esercitazione3;

public record Dipendente(String nome, Seniority seniority, int numeroProgettiCompletati, Bonus bonus) implements Retribuibile, Valutabile {

    public Dipendente {
        if (nome == null || nome.isEmpty() || seniority == null || numeroProgettiCompletati < 0 || bonus == null) {
            throw new IllegalArgumentException("Dipendente non valido");
        }
    }

    @Override
    public double calcolaStipendioBase() {
        if (seniority == Seniority.JUNIOR)
            return 1350.0;
        return 1650.0;
    }

    @Override
    public double calcolaBonus() {
        return bonus.calcolaBonus(this.calcolaValutazione());
    }

    @Override
    public int getNumeroProgetti() {
        return numeroProgettiCompletati;
    }

    @Override
    public String dettaglio() {
        return "Nome: " + nome + " -- " + this.seniority + "\nStipendio totale: " + Retribuibile.super.dettaglio() + "\n" + Valutabile.super.dettaglio();
    }
}
