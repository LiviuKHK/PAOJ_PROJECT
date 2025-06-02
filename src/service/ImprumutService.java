package service;

import domain.Imprumut;
import persistence.ImprumutDAO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class ImprumutService {
    private final ImprumutDAO dao = new ImprumutDAO();

    public void adaugaImprumut(int carteId, int cititorId) {
        try {
            Imprumut i = new Imprumut(carteId, cititorId, LocalDate.now());
            dao.adaugaImprumut(i);
            System.out.println("Împrumut adăugat cu succes.");
            AuditService.getInstance().logAction("Adaugare imprumut");
        } catch (SQLException e) {
            System.out.println("Eroare la adăugare împrumut: " + e.getMessage());
        }
    }

    public void afiseazaImprumuturi() {
        try {
            List<Imprumut> lista = dao.getToateImprumuturile();
            if (lista.isEmpty()) System.out.println("Niciun împrumut găsit.");
            else lista.forEach(System.out::println);
        } catch (SQLException e) {
            System.out.println("Eroare la afișare împrumuturi: " + e.getMessage());
        }
    }
}
