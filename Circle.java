package Ex2;

public class Circle extends Form {
    private float radius;

    public Circle() {
        super();
        this.radius = 1.0f;
    }

    public Circle(String color, float radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Cerc: " + getColor() + " " + getArea();
    }

    @Override
    public void printDimensions() {
        System.out.println("Rază: " + radius);
    }
}




