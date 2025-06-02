package domain;

public class Adresa {
    private int id;
    private String strada;
    private String oras;

    public Adresa(int id, String strada, String oras) {
        this.id = id;
        this.strada = strada;
        this.oras = oras;
    }

    public Adresa(String strada, String oras) {
        this.strada = strada;
        this.oras = oras;
    }

    public int getId() { return id; }
    public String getStrada() { return strada; }
    public String getOras() { return oras; }

    @Override
    public String toString() {
        return "Adresa{id=" + id + ", strada='" + strada + "', oras='" + oras + "'}";
    }
}
