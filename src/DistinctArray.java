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
        array = distinctElements(array);
        System.out.println(Arrays.toString(array));
    }

    public static int[] distinctElements(int[] array) {
        int[] clone = Arrays.copyOf(array, array.length);
        int counter = 0;
        Arrays.sort(clone);
            for (int i = 1; i < clone.length; i++) {
                if (clone[i] == clone[i - 1]) {
                    clone[i - 1] = 0;
                } else {
                    counter++;
                }
            }
        Arrays.sort(clone);
        int[] sortedArray =  Arrays.copyOfRange(clone, clone.length - (counter + 1), clone.length);
        boolean[] isPutted = new boolean[sortedArray.length];
        int[] distinctArray = new int[sortedArray.length];
        int distinctArrayCounter = 0;
        for (int element : array) {
            for (int j = 0; j < sortedArray.length; j++) {
                if (element == sortedArray[j] && !isPutted[j]) {
                    distinctArray[distinctArrayCounter++] = element;
                    isPutted[j] = true;
                }
            }
        }
       return distinctArray;
    }
}
