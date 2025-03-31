package Ex2;

public class Triangle extends Form {
    private float height;
    private float base;

    public Triangle() {
        super();
        this.height = 1.0f;
        this.base = 1.0f;
    }

    public Triangle(String color, float height, float base) {
        super(color);
        this.height = height;
        this.base = base;
    }

    @Override
    public double getArea() {
        return (base * height) / 2;
    }

    @Override
    public String toString() {
        return "Triunghi: " + getColor() + " " + getArea();
    }

    @Override
    public void printDimensions() {
        System.out.println("Baza: " + base + ", Înălțime: " + height);
    }
}

//Două obiecte de tip Triangle sunt considerate egale dacă au aceeași culoare, înălțime și bază.


