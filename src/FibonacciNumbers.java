import java.util.Scanner;

public class FibonacciNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        int userNumber = scanner.nextInt();
        calculatingNumbersRecursion(userNumber);
    }

    public static void calculatingNumbers(int userNumber){
        int result = 1;
        int secondNumber = 0;
        int firstNumber = 1;
       while(result < userNumber){
           System.out.print(result + " ");
           result = firstNumber + secondNumber ;
           secondNumber = firstNumber;
           firstNumber = result;
        }
    }

    public static void calculatingNumbersRecursion(int userNumber){
        if(userNumber == 1){
            return;
        }
        if(userNumber == 2){
            System.out.print("1 ");
        }
        int result = 1;
        int firstNumber = 1;
        int secondNumber = 0;
        while(result < userNumber){
            result = firstNumber + secondNumber ;
            secondNumber = firstNumber;
            firstNumber = result;
        }
        calculatingNumbersRecursion(secondNumber);
        System.out.print(secondNumber + " ");
    }
}
