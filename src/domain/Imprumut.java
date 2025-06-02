package domain;

import java.time.LocalDate;

public class Imprumut {
    private int id;
    private int carteId;
    private int cititorId;
    private LocalDate dataImprumut;

    public Imprumut(int id, int carteId, int cititorId, LocalDate dataImprumut) {
        this.id = id;
        this.carteId = carteId;
        this.cititorId = cititorId;
        this.dataImprumut = dataImprumut;
    }

    public Imprumut(int carteId, int cititorId, LocalDate dataImprumut) {
        this(-1, carteId, cititorId, dataImprumut);
    }

    public int getId() { return id; }
    public int getCarteId() { return carteId; }
    public int getCititorId() { return cititorId; }
    public LocalDate getDataImprumut() { return dataImprumut; }

    @Override
    public String toString() {
        return "Imprumut{" +
                "id=" + id +
                ", carteId=" + carteId +
                ", cititorId=" + cititorId +
                ", dataImprumut=" + dataImprumut +
                '}';
    }
}
