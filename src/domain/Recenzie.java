package domain;

public class Recenzie {
    private Carte carte;
    private String continut;

    public Recenzie(Carte carte, String continut) {
        this.carte = carte;
        this.continut = continut;
    }

    public Carte getCarte() { return carte; }
    public String getContinut() { return continut; }
}