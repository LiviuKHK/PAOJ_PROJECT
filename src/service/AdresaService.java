package service;

import domain.Adresa;
import persistence.AdresaDAO;

import java.sql.SQLException;
import java.util.List;

public class AdresaService {
    private final AdresaDAO dao = new AdresaDAO();

    public void afiseazaAdrese() {
        try {
            List<Adresa> lista = dao.getToateAdresele();
            if (lista.isEmpty()) System.out.println("Nu există adrese.");
            else lista.forEach(System.out::println);
        } catch (SQLException e) {
            System.out.println("Eroare la afișarea adreselor: " + e.getMessage());
        }
    }

    public void adaugaAdresa(String strada, String oras) {
        try {
            Adresa adresa = new Adresa(strada, oras);
            dao.adaugaAdresa(adresa);
            System.out.println("Adresă adăugată cu succes!");
            AuditService.getInstance().logAction("Adaugare adresă");
        } catch (SQLException e) {
            System.out.println("Eroare la adăugarea adresei: " + e.getMessage());
        }
    }

}
