import java.util.Arrays;
import java.util.Random;

public class ArrayMerge {

    public static void main(String[] args) {
        int[] firstArray = new int[10];
        int[] secondArray = new int[8];
        Random random = new Random();
            for (int i = 0; i < firstArray.length; i++) {
                firstArray[i] = random.nextInt(50);
            }
            for (int i = 0; i < secondArray.length; i++) {
                secondArray[i] = random.nextInt(50);
            }
        System.out.println(Arrays.toString(firstArray));
        System.out.println(Arrays.toString(secondArray));
        System.out.println(Arrays.toString(merge(firstArray, secondArray)));
    }

    public static int[] merge(int[] firstArray, int[] secondArray) {
        int mergeCounter = 0;
        int firstCounter = 0;
        int secondCounter = 0;
        int[] mergeArray = new int[firstArray.length + secondArray.length];
            while (mergeCounter < mergeArray.length) {
                if (firstCounter < firstArray.length) {
                    mergeArray[mergeCounter] = firstArray[firstCounter];
                    mergeCounter++;
                    firstCounter++;
                }
                if (secondCounter < secondArray.length) {
                    mergeArray[mergeCounter] = secondArray[secondCounter];
                    mergeCounter++;
                    secondCounter++;
                }
            }
        return mergeArray;
    }
}
