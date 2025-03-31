package Ex2;

public abstract class Form {
    private String color;

    public Form() {
        this.color = "necunoscut";
    }

    public Form(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public abstract double getArea();

    public abstract void printDimensions();

    @Override
    public String toString() {
        return color;
    }
}



