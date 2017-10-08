package figures;

public class Rectangle extends Parallelogram {

    public Rectangle(Point leftBottom, Point rightTop) {
        super(leftBottom, rightTop, Math.abs(Math.max(leftBottom.getX(), rightTop.getX())
                - Math.min(leftBottom.getX(), rightTop.getX())));
    }

    @Override
    public String toString() {
        return "Прямоугольник с кординатами левой нижней точки (" + getLeftBottom().getX() + "," +getLeftBottom().getY() +
                ") и правой верхней точки (" + getRightTop().getX() + "," + getRightTop().getY() + ")";
    }
}
