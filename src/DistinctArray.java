import java.util.Arrays;
import java.util.Random;

public class DistinctArray {

    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10];
            for (int i = 0; i < array.length; i++) {
                array[i] = random.nextInt(15);
            }
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println(Arrays.toString(distinctElements(array)));
    }

    public static int[] distinctElements(int[] array) {
        int counter = 0;
        int[] distinctArray;
        Arrays.sort(array);
            for (int i = 1; i < array.length; i++) {
                if(array[i] == array[i - 1]) {
                    array[i - 1] = 0;
                } else {
                    counter++;
                }
            }
        distinctArray = new int[counter+1];
        for (int number : array) {
            if(number != 0) {
                distinctArray[counter] = number;
                counter--;
            }
        }
        return distinctArray;
    }
}
