package figures;

public interface ScalableFigure extends Figure {

    public double perimeter();

    public double square();

    public static double square(ScalableFigure figure) {
        return figure.square();
    }

    public static void compareSquares(ScalableFigure firstFigure, ScalableFigure secondFigure) {
        System.out.println(firstFigure.square() == secondFigure.square() ? "Площади равны" : "Площади не равны");
    }

    public default void compareSquares(ScalableFigure figure) {
        System.out.println(this.square() == figure.square() ? "Площади равны" : "Площади не равны");
    }
}
