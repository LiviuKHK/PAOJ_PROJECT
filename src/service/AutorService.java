package service;

import domain.Autor;
import persistence.AutorDAO;

import java.sql.SQLException;
import java.util.List;

public class AutorService {
    private AutorDAO autorDAO = new AutorDAO();

    public void adaugaAutor(Autor autor) {
        try {
            if (autorDAO.existaAutorCuNume(autor.getNume())) {
                System.out.println("Autorul \"" + autor.getNume() + "\" există deja.");
                return;
            }

            autorDAO.adaugaAutor(autor);
            System.out.println("Autor adăugat cu succes!");
            AuditService.getInstance().logAction("Adaugare autor");

        } catch (SQLException e) {
            System.out.println("Eroare la adăugarea autorului: " + e.getMessage());
        }
    }

    public void afiseazaAutori() {
        try {
            List<Autor> autori = autorDAO.getTotiAutorii();
            if (autori.isEmpty()) {
                System.out.println("Nu există autori în sistem.");
            } else {
                for (Autor autor : autori) {
                    System.out.println(autor);
                }
            }
        } catch (SQLException e) {
            System.out.println("Eroare la afișarea autorilor: " + e.getMessage());
        }
    }

    public void actualizeazaAutor(int id, String numeNou) {
        try {
            Autor autor = new Autor(id, numeNou);
            autorDAO.actualizeazaAutor(autor);
            System.out.println("Autor actualizat cu succes!");
            AuditService.getInstance().logAction("Modificare autor");
        } catch (SQLException e) {
            System.out.println("Eroare la actualizarea autorului: " + e.getMessage());
        }
    }

    public void stergeAutor(int id) {
        try {
            autorDAO.stergeAutor(id);
            System.out.println("Autor șters cu succes!");
            AuditService.getInstance().logAction("Stergere autor");
        } catch (SQLException e) {
            System.out.println("Eroare la ștergerea autorului: " + e.getMessage());
        }
    }
}
