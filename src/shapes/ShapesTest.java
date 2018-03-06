package shapes;

public class ShapesTest {
    public static void main(String[] args) {
        Rectangle box1 = new Rectangle(5, 4);
        System.out.println("box1\narea: " + box1.getArea() + " " + "length: " + box1.getPerimeter());
        Rectangle box2 = new Rectangle(5);
        System.out.println("box2\narea: " + box2.getArea() + " " + "length: " + box2.getPerimeter());
    }
}
