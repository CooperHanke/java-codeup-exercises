package shapes;

public abstract class Quadrilateral implements Measurable{
    protected double length, width;
    public Quadrilateral (double length, double width) {
        this.length = length;
        this.width = width;
    }
    public double getLength() {
        return this.length;
    }
    public double getWidth() {
        return this.width;
    }
    abstract void setLength();
    abstract void setWidth();
}
