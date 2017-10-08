package figures;

public class Ellipse implements ScalableFigure {

    private int secondRadius;
    private Point center;
    private int firstRadius;

    public Ellipse(Point center, int firstRadius, int secondRadius) {
        this.center = center;
        this.firstRadius = firstRadius;
        this.secondRadius = secondRadius;
    }

    public double diameter() {
        return getFirstRadius() * 2 > getSecondRadius() * 2 ? getFirstRadius() * 2 : getSecondRadius() * 2;
    }

    @Override
    public double perimeter() {
        return ((Math.PI * getFirstRadius() * getSecondRadius() + Math.pow(getFirstRadius() - getSecondRadius(), 2))
                / (getSecondRadius() + getFirstRadius())) * 4;
    }

    @Override
    public double square() {
        return Math.PI * getFirstRadius() * getSecondRadius();
    }

    public int getSecondRadius() {
        return secondRadius;
    }

    public Point getCenter() {
        return center;
    }

    public int getFirstRadius() {
        return firstRadius;
    }

    @Override
    public String toString() {
        return "Окружность с центром в точке (" + getCenter().getX() + "," + getCenter().getY()
                + "), и радиусами: " + getFirstRadius() + ", " + getSecondRadius() + ".";
    }
}
