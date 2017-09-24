import java.util.Scanner;

public class TwoHouses {

    public static void main(String[] args) {
        setSizes();
    }

    public static void setSizes() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размеры первого дома (сторона 1,  сторона 2)");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println("Введите размеры второго дома (сторона 1,  сторона 2)");
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        System.out.println("Введите размеры участка (сторона 1,  сторона 2)");
        int e = scanner.nextInt();
        int f = scanner.nextInt();
        System.out.println(checkPlacement(a, b, c, d, e, f) ? "Дома помещаются" : "Дома не помещаются");
    }

    public static boolean checkPlacement(int a, int b, int c, int d, int e, int f) {
        if (max(e, f) >= max(a, b) && min(e, f) >= min(a, b) && max(e, f) >= max(c, d) && min(e, f) >= min(c, d)) {
            if (max(a, b) + max(c, d) >= max(e, f)) {
                return true;
            } else if (min(a, b) + min(c, d) >= min(e, f)) {
                return true;
            } else if (min(a, b) + max(c, d) >= max(e, f) && max(a, b) >= min(e, f)) {
                return true;
            } else if (max(a, b) + min(c, d) >= max(e, f) && max(c, d) >= min(e, f)) {
                return true;
            }
        }
        return false;
    }

        public static int max(int firstSide, int secondSide){
            return firstSide <= secondSide ? secondSide : firstSide;
        }

        public static int min(int firstSide, int secondSide){
            return firstSide <= secondSide ? firstSide : secondSide;
        }
}
