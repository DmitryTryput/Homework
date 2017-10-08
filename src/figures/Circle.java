package figures;

public class Circle extends Ellipse {

    public Circle(Point center, int radius) {
        super(center, radius, radius);
    }

    @Override
    public double diameter() {
        return getFirstRadius() * 2;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * getFirstRadius();
    }

    @Override
    public double square() {
        return (Math.PI * Math.pow(diameter(),2)) / 4;
    }

    @Override
    public String toString() {
        return "Окружность с центром в точке (" + getCenter().getX() + "," + getCenter().getY() + "), и радиусом " + getFirstRadius();
    }
}
