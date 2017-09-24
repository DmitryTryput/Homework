import java.util.Scanner;

public class WeatherStatistics {

    public static void main(String[] args) {
        statisticsInput();
    }

    public static  void statisticsInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество дней");
        int days = scanner.nextInt();
        int counter = 1;
        int maxValue = 0;
        int precipitationSum = 0;
        System.out.println("Введите количество осадков в день");
            while (counter <= days){
            int precipitationValue = scanner.nextInt();
            precipitationSum += precipitationValue;
            if(precipitationValue > maxValue) {
                maxValue = precipitationValue;
            }
                counter++;
        }
        statisticsOutput(days, precipitationSum, maxValue);
    }

    public static void statisticsOutput(int days, int precipitationSum, int maxValue){
        System.out.println("Количество дней: " + days);
        System.out.println("Сумма осадков за период: " + precipitationSum);
        System.out.println("Среднее количество осадков за период: " + precipitationSum/days);
        System.out.println("Максимальное количество осадков за период: " + maxValue);
    }
}
