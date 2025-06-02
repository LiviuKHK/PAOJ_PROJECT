package service;

import domain.Autor;
import domain.Carte;
import persistence.AutorDAO;
import persistence.CarteDAO;

import java.sql.SQLException;
import java.util.List;

public class CarteService {
    private final CarteDAO carteDAO;
    private final AutorDAO autorDAO;

    public CarteService() {
        this.carteDAO = new CarteDAO();
        this.autorDAO = new AutorDAO();
    }

    public void adaugaCarte(Carte carte) {
        try {
            carteDAO.adaugaCarte(carte);
            System.out.println("Carte adăugată cu succes!");
        } catch (SQLException e) {
            System.out.println("Eroare la adăugarea cărții: " + e.getMessage());
        }
    }

    public void afiseazaCarti() {
        try {
            List<Carte> carti = carteDAO.getToateCartile();
            for (Carte c : carti) {
                System.out.println(c);
            }
        } catch (SQLException e) {
            System.out.println("Eroare la afișarea cărților: " + e.getMessage());
        }
    }

    public void adaugaCarteCuAutor(String titlu, int anPublicatie, String numeAutor) {
        try {

            Autor autorGasit = autorDAO.gasesteAutorDupaNume(numeAutor);
            if (autorGasit == null) {

                Autor autorNou = new Autor(numeAutor);
                autorDAO.adaugaAutor(autorNou);
                autorGasit = autorDAO.gasesteAutorDupaNume(numeAutor);
            }

            Carte carte = new Carte(titlu, anPublicatie, autorGasit.getId());
            adaugaCarte(carte);
            AuditService.getInstance().logAction("Adaugare carte");

        } catch (SQLException e) {
            System.out.println("Eroare la adăugarea cărții cu autor: " + e.getMessage());
        }
    }

    public void modificaCarte(int id, String nouTitlu, int anPublicatie, String numeAutorNou, boolean disponibila) {
        try {
            Autor autor = autorDAO.gasesteAutorDupaNume(numeAutorNou);
            if (autor == null) {
                Autor autorNou = new Autor(numeAutorNou);
                autorDAO.adaugaAutor(autorNou);
                autor = autorDAO.gasesteAutorDupaNume(numeAutorNou);
            }

            Carte carteNoua = new Carte(id, nouTitlu, anPublicatie, autor.getId());
            carteNoua.setDisponibila(disponibila);
            carteDAO.updateCarte(carteNoua);

            System.out.println("Carte actualizată cu succes!");
            AuditService.getInstance().logAction("Modificare carte");

        } catch (SQLException e) {
            System.out.println("Eroare la actualizarea cărții: " + e.getMessage());
        }
    }

    public void stergeCarte(int id) {
        try {
            boolean rezultat = carteDAO.deleteCarte(id);
            if (rezultat) {
                System.out.println("Carte ștearsă cu succes!");
                AuditService.getInstance().logAction("Stergere carte");
            } else {
                System.out.println("Carte cu ID-ul " + id + " nu a fost găsită.");
            }
        } catch (SQLException e) {
            System.out.println("Eroare la ștergerea cărții: " + e.getMessage());
        }
    }

}
