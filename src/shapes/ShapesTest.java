package shapes;

public abstract class ShapesTest implements Measurable{
    Measurable myShape = new Measurable() {
        @Override
        public double getArea() {
            return myShape.getArea();
        }
        public double getPerimeter() {
            return myShape.getPerimeter();
        }
    };

    public static void main(String[] args) {
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
