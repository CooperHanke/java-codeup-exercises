package shapes;

public class Square extends Rectangle{
    private int side;
    public Square(int length, int width) {
        super(length, width);
        this.side = length;
        this.side = width;
    }
    public int getArea() {
        return side * side;
    }
    public int getPerimeter () {
        return side * 4;
    }
}
