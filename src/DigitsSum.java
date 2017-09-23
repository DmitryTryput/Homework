import java.util.Scanner;

public class DigitsSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        int number = scanner.nextInt();
        System.out.println("Сумма цифр числа: " + calculation(number));
    }
    public static int calculation(int number){
        int result = 0;
        while(number > 0){
            result += number % 10;
            number /=10;
        }
        return result;
    }
}
