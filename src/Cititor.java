public class Cititor {
    private String nume;
    private Adresa adresa;

    public Cititor(String nume, Adresa adresa) {
        this.nume = nume;
        this.adresa = adresa;
    }

    public String getNume() { return nume; }
    public Adresa getAdresa() { return adresa; }
}
