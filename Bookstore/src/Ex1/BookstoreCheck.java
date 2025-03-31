package Ex1;

public class BookstoreCheck {

    public static boolean isDuplicate(Book b1, Book b2) {
        return b1.getTitle().equalsIgnoreCase(b2.getTitle()) &&
                b1.getAuthor().equalsIgnoreCase(b2.getAuthor()) &&
                b1.getPublisher().equalsIgnoreCase(b2.getPublisher());
    }

    public static Book thickerBook(Book b1, Book b2) {
        return (b1.getPageCount() >= b2.getPageCount()) ? b1 : b2;
    }

    public static void main(String[] args) {
        Book book1 = new Book("Java Programming", "John Doe", "Tech Press", 300);
        Book book2 = new Book("Java Programming", "John Doe", "Tech Press", 300);
        Book book3 = new Book("Data Structures", "Robert Martin", "CS Press", 400);

        System.out.println("\n--- TEST DUPLICATE ---");
        if (isDuplicate(book1, book2)) {
            System.out.println("Cartea 1 și Cartea 2 sunt duplicate.");
        } else {
            System.out.println("Cartea 1 și Cartea 2 NU sunt duplicate.");
        }

        if (isDuplicate(book1, book3)) {
            System.out.println("Cartea 1 și Cartea 3 sunt duplicate.");
        } else {
            System.out.println("Cartea 1 și Cartea 3 NU sunt duplicate.");
        }

        System.out.println("\n--- TEST CARTEA MAI GROSĂ ---");
        Book thicker = thickerBook(book1, book3);
        System.out.println("Cartea mai groasă este: " + thicker);
    }
}
