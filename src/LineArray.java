import java.util.Arrays;
import java.util.Random;

public class LineArray {

    public static void main(String[] args) {
        Random random = new Random();
        int[][] array = new int[random.nextInt(10)][];
            for (int i = 0; i < array.length; i++) {
                array[i] = new int [random.nextInt(10)];
            }
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = random.nextInt(100);
                }
            }
        System.out.println(Arrays.deepToString(array));
        System.out.println(Arrays.toString(lineArray(array)));
    }

    public static int[] lineArray(int[][] array) {
        int counter = 0;
        int size = 0;
        for (int[] anArray : array) {
            size += anArray.length;
        }
        int[] lineArray = new int[size];
        for (int[] outerArray : array) {
            for (int innerArray : outerArray) {
                lineArray[counter] = innerArray;
                counter++;
            }
        }
        return lineArray;
    }
}
