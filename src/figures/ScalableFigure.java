package figures;

public interface ScalableFigure extends Figure {

    double perimeter();

    double square();

    static double square(figures.ScalableFigure figure) {
        return figure.square();
    }

    static void compareSquares(figures.ScalableFigure firstFigure, figures.ScalableFigure secondFigure) {
        System.out.println(firstFigure.square() == secondFigure.square() ? "Площади равны" : "Площади не равны");
    }

    default void compareSquares(figures.ScalableFigure figure) {
        System.out.println(this.square() == figure.square() ? "Площади равны" : "Площади не равны");
    }
}

