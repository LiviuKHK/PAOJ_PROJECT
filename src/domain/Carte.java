package domain;

public class Carte {
    private int id;
    private String titlu;
    private int anPublicare;
    private int autorId;
    private boolean disponibila;


    public Carte(int id, String titlu, int anPublicare, int autorId) {
        this.id = id;
        this.titlu = titlu;
        this.anPublicare = anPublicare;
        this.autorId = autorId;
        this.disponibila = true;

    }

    public Carte(String titlu, int anPublicare, int autorId) {
        this.titlu = titlu;
        this.anPublicare = anPublicare;
        this.autorId = autorId;
        this.disponibila = true;

    }

    public int getId() { return id; }
    public String getTitlu() { return titlu; }
    public int getAnPublicatie() { return anPublicare; }
    public int getAutorId() { return autorId; }

    public void setId(int id) { this.id = id; }
    public void setTitlu(String titlu) { this.titlu = titlu; }
    public void setAnPublicatie(int anPublicare) { this.anPublicare = anPublicare; }
    public void setAutorId(int autorId) { this.autorId = autorId; }
    public boolean isDisponibila() {
        return disponibila;
    }

    public void setDisponibila(boolean disponibila) {
        this.disponibila = disponibila;
    }


    @Override
    public String toString() {
        return "Carte{" +
                "id=" + id +
                ", titlu='" + titlu + '\'' +
                ", anPublicare=" + anPublicare +
                ", autorId=" + autorId +
                ", disponibila=" + (disponibila ? "da" : "nu") +
                '}';
    }

}
