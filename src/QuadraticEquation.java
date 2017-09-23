import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Введите a");
      int a = scanner.nextInt();
      System.out.println("Введите b");
      int b = scanner.nextInt();
      System.out.println("Введите c");
      int c = scanner.nextInt();
      rootsCalculation(a, b, c);
    }

    public static void rootsCalculation(int a, int b, int c){
        if(isPositive(discriminant(a, b, c))){
            double x1 = (-b + Math.sqrt(discriminant(a, b, c) / 2 * a));
            double x2 = (-b - Math.sqrt(discriminant(a, b, c) / 2 * a));
            System.out.println("Корени уравнения: " + x1 + " " + x2);
        }else if(isZero(discriminant(a, b, c))){
            double x1 = - b / (2 * a);
            System.out.println("Корень уравнения: " + x1);
        }else {
            System.out.println("Отрицательный дискрминант : " + discriminant(a, b, c));
        }
    }

    public static int discriminant(int a, int b, int c){
        return ((b * b) - (4 * a * c));
    }

    public static boolean isPositive(double number){
        return number > 0;
    }

    public static boolean isZero(double number){
        return number == 0;
    }
}
