package Ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookstoreTest {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Cartea a fost adăugată.\n");
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("Nu există cărți în librărie.\n");
        } else {
            System.out.println("\n--- LISTA DE CARTI ---");
            for (Book book : books) {
                book.displayBookInfo(); // Apelăm metoda de afișare formatată
                System.out.println(); // Spațiu pentru lizibilitate
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookstoreTest bookstore = new BookstoreTest();
        boolean running = true;

        while (running) {
            System.out.println("\n--- MENIU ---");
            System.out.println("1. Adaugă o carte");
            System.out.println("2. Afișează toate cărțile");
            System.out.println("3. Ieșire");
            System.out.print("Alege o opțiune: ");

            int option;
            while (!scanner.hasNextInt()) {  // Verificăm dacă utilizatorul introduce un număr valid
                System.out.println("Eroare! Introduceți un număr valid.");
                scanner.next();
            }
            option = scanner.nextInt();
            scanner.nextLine(); // Consumăm newline

            switch (option) {
                case 1:
                    System.out.println("\n--- INTRODUCERE DATE CARTE ---");

                    System.out.print("Introduceți titlul cărții: ");
                    String title = scanner.nextLine();

                    System.out.print("Introduceți autorul cărții: ");
                    String author = scanner.nextLine();

                    System.out.print("Introduceți editura cărții: ");
                    String publisher = scanner.nextLine();

                    int pageCount;
                    do {
                        System.out.print("Introduceți numărul de pagini (trebuie să fie mai mare ca 0): ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Eroare! Introduceți un număr valid.");
                            scanner.next();
                        }
                        pageCount = scanner.nextInt();
                        scanner.nextLine();
                    } while (pageCount <= 0);

                    // Creăm cartea și o adăugăm în librărie
                    Book book = new Book(title, author, publisher, pageCount);
                    bookstore.addBook(book);

                    break;

                case 2:
                    bookstore.listBooks();
                    break;

                case 3:
                    running = false;
                    System.out.println("Ieșire din program. La revedere!");
                    break;

                default:
                    System.out.println("Opțiune invalidă. Alegeți din nou.");
            }
        }

        scanner.close();
    }
}
