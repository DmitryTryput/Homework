package lesson6;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(10, 10, -10, 0);
        System.out.println(rectangle.diameter());
        System.out.println(rectangle.square());
        Rectangle pointsRectangle = new Rectangle(new Point(5, 5), new Point(10, 10));
        System.out.println(pointsRectangle.square());
        System.out.println(pointsRectangle.diameter());
    }
}
