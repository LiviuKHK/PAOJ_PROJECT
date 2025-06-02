package view;


import domain.Autor;
import service.AdresaService;
import service.AutorService;
import service.CarteService;
import service.ImprumutService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarteService carteService = new CarteService();
        AutorService autorService = new AutorService();
        AdresaService adresaService = new AdresaService();
        ImprumutService imprumutService = new ImprumutService();

        boolean running = true;
        while (running) {
            System.out.println("\n=== Meniu principal ===");
            System.out.println("1. Detalii cărți");
            System.out.println("2. Detalii autori");
            System.out.println("3. Detalii adrese");
            System.out.println("4. Detalii împrumuturi");
            System.out.println("0. Ieșire");

            int optiune = scanner.nextInt();
            scanner.nextLine();

            switch (optiune) {
                case 1 -> meniuCarti(scanner, carteService);
                case 2 -> meniuAutori(scanner, autorService);
                case 3 -> meniuAdrese(scanner, adresaService);
                case 4 -> meniuImprumuturi(scanner, imprumutService);
                case 0 -> {
                    running = false;
                    System.out.println("La revedere!");
                }
                default -> System.out.println("Opțiune invalidă!");
            }
        }
    }

    private static void meniuCarti(Scanner scanner, CarteService carteService) {
        boolean inMeniuCarti = true;
        while (inMeniuCarti) {
            System.out.println("\n--- Meniu cărți ---");
            System.out.println("1. Adaugă carte");
            System.out.println("2. Afișează cărți");
            System.out.println("3. Modifică carte");
            System.out.println("4. Șterge carte");
            System.out.println("0. Înapoi");

            int optiune = scanner.nextInt();
            scanner.nextLine();

            switch (optiune) {
                case 1 -> {
                    System.out.print("Titlu: ");
                    String titlu = scanner.nextLine();
                    System.out.print("An publicare: ");
                    int an = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nume autor: ");
                    String autor = scanner.nextLine();
                    carteService.adaugaCarteCuAutor(titlu, an, autor);
                }
                case 2 -> carteService.afiseazaCarti();
                case 3 -> {
                    System.out.print("ID carte: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Titlu nou: ");
                    String titluNou = scanner.nextLine();
                    System.out.print("An publicare nou: ");
                    int anNou = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nume autor nou: ");
                    String autorNou = scanner.nextLine();
                    System.out.print("Este disponibilă? (true/false): ");
                    boolean disponibila = scanner.nextBoolean();

                    carteService.modificaCarte(id, titluNou, anNou, autorNou, disponibila);
                }
                case 4 -> {
                    System.out.print("ID carte de șters: ");
                    int id = scanner.nextInt();
                    carteService.stergeCarte(id);
                }
                case 0 -> inMeniuCarti = false;
                default -> System.out.println("Opțiune invalidă!");
            }
        }
    }

    private static void meniuAutori(Scanner scanner, AutorService autorService) {
        boolean inapoi = false;

        while (!inapoi) {
            System.out.println("\n--- Meniu Autori ---");
            System.out.println("1. Adaugă autor");
            System.out.println("2. Afișează autori");
            System.out.println("3. Actualizează autor");
            System.out.println("4. Șterge autor");
            System.out.println("0. Înapoi");
            System.out.print("Alegere: ");

            int alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere) {
                case 1:
                    System.out.print("Nume autor: ");
                    String nume = scanner.nextLine();
                    autorService.adaugaAutor(new Autor(nume));
                    break;
                case 2:
                    autorService.afiseazaAutori();
                    break;
                case 3:
                    System.out.print("ID autor de actualizat: ");
                    int idUpdate = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nume nou: ");
                    String numeNou = scanner.nextLine();
                    autorService.actualizeazaAutor(idUpdate, numeNou);
                    break;
                case 4:
                    System.out.print("ID autor de șters: ");
                    int idDelete = Integer.parseInt(scanner.nextLine());
                    autorService.stergeAutor(idDelete);
                    break;
                case 0:
                    inapoi = true;
                    break;
                default:
                    System.out.println("Opțiune invalidă.");
            }
        }

    }
    private static void meniuAdrese(Scanner scanner, AdresaService adresaService) {
        boolean inapoi = false;

        while (!inapoi) {
            System.out.println("\n--- Meniu Adrese ---");
            System.out.println("1. Adaugă adresă");
            System.out.println("2. Afișează adrese");
            System.out.println("0. Înapoi");
            System.out.print("Alegere: ");

            int alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere) {
                case 1 -> {
                    System.out.print("Strada: ");
                    String strada = scanner.nextLine();
                    System.out.print("Oraș: ");
                    String oras = scanner.nextLine();
                    adresaService.adaugaAdresa(strada, oras);
                }
                case 2 -> adresaService.afiseazaAdrese();
                case 0 -> inapoi = true;
                default -> System.out.println("Opțiune invalidă.");
            }
        }
    }

    private static void meniuImprumuturi(Scanner scanner, ImprumutService imprumutService) {
        boolean inapoi = false;

        while (!inapoi) {
            System.out.println("\n--- Meniu Împrumuturi ---");
            System.out.println("1. Adaugă împrumut");
            System.out.println("2. Afișează împrumuturi");
            System.out.println("0. Înapoi");
            System.out.print("Alegere: ");

            int alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere) {
                case 1 -> {
                    System.out.print("ID carte: ");
                    int idCarte = Integer.parseInt(scanner.nextLine());
                    System.out.print("ID cititor: ");
                    int idCititor = Integer.parseInt(scanner.nextLine());
                    imprumutService.adaugaImprumut(idCarte, idCititor);
                }
                case 2 -> imprumutService.afiseazaImprumuturi();
                case 0 -> inapoi = true;
                default -> System.out.println("Opțiune invalidă.");
            }
        }
    }

}

