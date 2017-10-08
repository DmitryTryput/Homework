package figures;

public class Triangle implements ScalableFigure, Polygon {

    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;

    public Triangle(Point firstPoint, Point secondPoint, Point thirdPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
    }

    @Override
    public double high() {
        return 2 * Math.sqrt(halfPerimeter() * (halfPerimeter() - firstSide()) *
                (halfPerimeter() - secondSide()) * (halfPerimeter() - thirdSide())) / firstSide();
    }

    @Override
    public double perimeter() {
        return getFirstPoint().distance(getSecondPoint()) + getFirstPoint().distance(getThirdPoint())
                + getSecondPoint().distance(getThirdPoint());
    }

    @Override
    public double square() {
        return high() * firstSide() / 2;
    }

    public double halfPerimeter() {
        return perimeter() / 2;
    }

    public double firstSide() {
        return getFirstPoint().distance(getSecondPoint());
    }

    public double secondSide() {
        return getFirstPoint().distance(getThirdPoint());
    }

    public double thirdSide() {
        return getSecondPoint().distance(getThirdPoint());
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public Point getThirdPoint() {
        return thirdPoint;
    }

    public String toString() {
        return "Треугольник с кординатами углов: (" + getFirstPoint().getX() + "," + getFirstPoint().getY() + "), ("
                + getSecondPoint().getX() + "," + getSecondPoint().getY() + "), ("
                + getThirdPoint().getX() + "," + getThirdPoint().getY() + ").";
    }
}
