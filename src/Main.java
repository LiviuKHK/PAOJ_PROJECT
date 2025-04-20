public class Main {
    public static void main(String[] args) {
        BibliotecaService biblioteca = new BibliotecaService();

        Autor autor1 = new Autor("Mihai Eminescu");
        Autor autor2 = new Autor("Ion Creanga");

        Carte carte1 = new Carte("Luceafarul", autor1, "Poezie", 1883);
        Carte carte2 = new Carte("Povestea unui om lenes", autor2, "Poveste", 1900);
        Carte carte3 = new Carte("Amintiri din copilarie", autor2, "Poveste", 1892);

        Adresa adresa1 = new Adresa("Str. Libertatii", "Iasi");
        Adresa adresa2 = new Adresa("Bd. Independentei", "Cluj");

        Cititor cititor1 = new MembruPremium("Ion Popescu", adresa1, 10);
        Cititor cititor2 = new Cititor("Maria Ionescu", adresa2);

        // 1.Adaugare carti
        biblioteca.adaugaCarte(carte1);
        biblioteca.adaugaCarte(carte2);
        biblioteca.adaugaCarte(carte3);

        // 2.Afisare carti
        System.out.println("\nCarti disponibile in biblioteca:");
        biblioteca.afiseazaCarti();

        // 3.Cautare carte dupa titlu
        System.out.println("\nCaut cartea 'Luceafarul':");
        biblioteca.cautaCarte("Luceafarul");

        // 4.Imprumut carte
        biblioteca.imprumutaCarte(carte1, cititor1);
        biblioteca.imprumutaCarte(carte2, cititor2);

        // 5.Afisare imprumuturi
        System.out.println("\nImprumuturi curente:");
        biblioteca.afiseazaImprumuturi();

        // 6.Adaugare recenzie
        biblioteca.adaugaRecenzie(carte1, "O capodopera a literaturii romane.");
        biblioteca.adaugaRecenzie(carte1, "Inspirational si profund.");

        // 7.Afisare recenzii pentru o carte
        System.out.println("\nRecenzii pentru 'Luceafarul':");
        biblioteca.afiseazaRecenzii(carte1);

        // 8.Returnare carte
        biblioteca.returneazaCarte(carte1);

        // 9.Reimprumut dupa returnare
        biblioteca.imprumutaCarte(carte1, cititor2);

        // 10.Recenzie si afisare pentru alta carte
        biblioteca.adaugaRecenzie(carte3, "Una dintre cele mai frumoase carti ale copilariei.");
        System.out.println("\nRecenzii pentru 'Amintiri din copilarie':");
        biblioteca.afiseazaRecenzii(carte3);

        // 11.Afisare carti cautate care nu exista
        System.out.println("\nCautare carte inexistenta:");
        biblioteca.cautaCarte("Baltagul");
    }
}
