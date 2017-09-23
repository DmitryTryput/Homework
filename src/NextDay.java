import java.util.Scanner;

public class NextDay {

    public static void main(String[] args) {
       setDate();
    }

    public static void setDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите день");
        int day = scanner.nextInt();
        System.out.println("Введите месяц");
        int month = scanner.nextInt();
        System.out.println("Введите год");
        int year = scanner.nextInt();
        dateUpdate(day, month, year);
    }

    public static void dateUpdate(int day, int month, int year){
        if(isRealDate(day, month, year)){
            switch(month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    System.out.println(incrementDay(day, month, year, 31));
                    break;

                case 4:
                case 6:
                case 9:
                case 11:
                    System.out.println(incrementDay(day, month, year, 30));
                    break;

                case 2:
                    System.out.println(isLeap(year) ? incrementDay(day, month, year, 29) :
                            incrementDay(day, month, year, 28));
            }
        }else{
            System.out.println("Дата " + day + "." + month + "." + year + " неверна");
        }
    }

    public static boolean isRealDate(int day, int month, int year){
        switch(month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return isInRange(day, 1, 31);

            case 4:
            case 6:
            case 9:
            case 11:
                 return isInRange(day, 1, 30);

            case 2:
                 return isLeap(year) ? isInRange(day, 1, 29) : isInRange(day, 1, 28);

            default:
                return false;
        }
    }

    public static boolean isInRange(int day, int from, int to){
        return day >= from && day <= to;
    }

    public static String incrementDay(int day, int month, int year, int lastDayOfMonth){
        String result;

        if(day == lastDayOfMonth){
            if(month == 12){
                year++;
               return result = "01.01." + year;
            }
            month++;
            return  result =  "01." + month + "." + year;
        }else{
            day++;
            return  result = day < 10 ? "0" + day + "." + month + "." + year : day + "." + month + "." + year;
        }
    }

    public static boolean isLeap(int year){
        return  year % 4 == 0 && ( !(year % 100 == 0) || year % 400 ==0);
    }

    public static void testUpdateDate(){
        for(int y = 3; y < 5; y++){
            for(int m = 1; m < 13; m++){
                for(int d = 1; d < 32; d++){
                    System.out.print(d + "." + m + "." + y + "    ");
                            dateUpdate(d, m, y);
                }
            }
        }
    }
}
