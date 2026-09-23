import java.util.*;

interface Shape {
    double CalculateArea();
    default void display() {
        System.out.printf("Area: %.2f\n", CalculateArea());
    }
}

class Circle implements Shape{
    double radius;

    public Circle(double r) {
        this.radius = r;
    }

    @Override 
    public double CalculateArea() {
        return (Math.PI * radius * radius);
    }
}

class Rectangle implements Shape{
    double width;
    double height;

    public Rectangle(double w, double h) {
        this.width = w;
        this.height = h;
    }

    @Override 
    public double CalculateArea() {
        return (width * height);
    }
}

public class test {

    public static void main(String[] args) {
        Circle c = new Circle(20.0);
        Rectangle r = new Rectangle(4.0, 5.0);

        c.display();
        r.display();
    }
}