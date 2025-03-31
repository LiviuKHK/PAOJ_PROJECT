package Ex2;

public class FormTest {
    public static void main(String[] args) {
        Form[] forms = new Form[3];
        forms[0] = new Triangle("roșu", 3.0f, 4.0f);
        forms[1] = new Circle("verde", 5.0f);
        forms[2] = new Triangle("albastru", 6.0f, 8.0f);

        for (Form form : forms) {
            System.out.println(form.toString());
            form.printDimensions();
        }
    }
}



