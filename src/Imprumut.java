import java.time.LocalDate;

public class Imprumut implements Comparable<Imprumut> {
    private Carte carte;
    private Cititor cititor;
    private LocalDate dataImprumut;

    public Imprumut(Carte carte, Cititor cititor) {
        this.carte = carte;
        this.cititor = cititor;
        this.dataImprumut = LocalDate.now();
    }

    public Carte getCarte() { return carte; }
    public Cititor getCititor() { return cititor; }
    public LocalDate getDataImprumut() { return dataImprumut; }

    @Override
    public int compareTo(Imprumut altul) {
        return this.dataImprumut.compareTo(altul.dataImprumut);
    }

    @Override
    public String toString() {
        return carte + " imprumutata de " + cititor.getNume() + " in data de " + dataImprumut;
    }
}
