package shapes;

public abstract class ShapesTest implements Measurable {

    public static void main(String[] args) {
//        Measurable myShape = new Measurable();\
        // Cannot be instantiated ^ Not valid code above!!
        Square square = new Square(10);
        System.out.println("Square:");
        System.out.println("Area: " + square.getArea());
        System.out.println("Perimeter: " + square.getPerimeter());
        Rectangle rect = new Rectangle(10,5);
        System.out.println("Rectangle:");
        System.out.println("Area: " + rect.getArea());
        System.out.println("Perimeter: " + rect.getPerimeter());
    }
}
