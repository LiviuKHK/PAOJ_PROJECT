public class Carte {
    private String titlu;
    private Autor autor;
    private String categorie;
    private int anPublicatie;
    private boolean disponibila;

    public Carte(String titlu, Autor autor, String categorie, int anPublicatie) {
        this.titlu = titlu;
        this.autor = autor;
        this.categorie = categorie;
        this.anPublicatie = anPublicatie;
        this.disponibila = true;
    }

    public String getTitlu() { return titlu; }
    public Autor getAutor() { return autor; }
    public String getCategorie() { return categorie; }
    public int getAnPublicatie() { return anPublicatie; }
    public boolean isDisponibila() { return disponibila; }

    public void setDisponibila(boolean disponibila) {
        this.disponibila = disponibila;
    }

    @Override
    public String toString() {
        return titlu + " de " + autor.getNume();
    }
}