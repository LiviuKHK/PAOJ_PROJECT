public class MembruPremium extends Cititor {
    private int puncteBonus;

    public MembruPremium(String nume, Adresa adresa, int puncteBonus) {
        super(nume, adresa);
        this.puncteBonus = puncteBonus;
    }

    public int getPuncteBonus() { return puncteBonus; }
    public void adaugaPuncte(int puncte) {
        this.puncteBonus += puncte;
    }
}