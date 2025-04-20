import java.util.*;

public class BibliotecaService {
    private List<Carte> carti = new ArrayList<>();
    private Set<Imprumut> imprumuturi = new TreeSet<>();
    private Map<Carte, List<Recenzie>> recenzii = new HashMap<>();

    public void adaugaCarte(Carte carte) {
        carti.add(carte);
    }

    public void afiseazaCarti() {
        carti.forEach(System.out::println);
    }

    public void cautaCarte(String titlu) {
        boolean gasita = false;
        for (Carte c : carti) {
            if (c.getTitlu().equalsIgnoreCase(titlu)) {
                System.out.println(c);
                gasita = true;
            }
        }
        if (!gasita) {
            System.out.println("Cartea \"" + titlu + "\" nu a fost gasita in biblioteca.");
        }
    }


    public void imprumutaCarte(Carte carte, Cititor cititor) {
        if (carte.isDisponibila()) {
            carte.setDisponibila(false);
            imprumuturi.add(new Imprumut(carte, cititor));
        }
    }

    public void returneazaCarte(Carte carte) {
        carte.setDisponibila(true);
    }

    public void afiseazaImprumuturi() {
        imprumuturi.forEach(System.out::println);
    }

    public void adaugaRecenzie(Carte carte, String text) {
        recenzii.computeIfAbsent(carte, k -> new ArrayList<>()).add(new Recenzie(carte, text));
    }

    public void afiseazaRecenzii(Carte carte) {
        List<Recenzie> lista = recenzii.get(carte);
        if (lista != null) lista.forEach(r -> System.out.println(r.getContinut()));
        else System.out.println("Nu exista recenzii.");
    }
}