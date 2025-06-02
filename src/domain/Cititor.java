package domain;

public class Cititor {
    private int id;
    private String nume;
    private int adresaId;

    public Cititor() {}

    public Cititor(int id, String nume, int adresaId) {
        this.id = id;
        this.nume = nume;
        this.adresaId = adresaId;
    }

    public Cititor(String nume, int adresaId) {
        this.nume = nume;
        this.adresaId = adresaId;
    }

    public Cititor(String nume, Adresa adresa) {
        this.nume = nume;
        this.adresaId = adresa.getId();
    }

    public int getId() { return id; }
    public String getNume() { return nume; }
    public int getAdresaId() { return adresaId; }

    public void setId(int id) { this.id = id; }
    public void setNume(String nume) { this.nume = nume; }
    public void setAdresaId(int adresaId) { this.adresaId = adresaId; }

    @Override
    public String toString() {
        return "Cititor{id=" + id + ", nume='" + nume + "', adresaId=" + adresaId + "}";
    }
}
