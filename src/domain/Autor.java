package domain;

public class Autor {
    private int id;
    private String nume;

    public Autor(int id, String nume) {
        this.id = id;
        this.nume = nume;
    }

    public Autor(String nume) {
        this.nume = nume;
    }

    public int getId() { return id; }
    public String getNume() { return nume; }

    public void setId(int id) { this.id = id; }
    public void setNume(String nume) { this.nume = nume; }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                '}';
    }
}
