import java.util.Arrays;
import java.util.Random;

public class LineArray {

    public static void main(String[] args) {
        Random random = new Random();
        int[][] array = new int[5][4];
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = random.nextInt(100);
                }
            }
        System.out.println(Arrays.deepToString(array));
        System.out.println(Arrays.toString(linearize(array)));
    }

    public static int[] linearize(int[][] array) {
        int counter = 0;
        int size = 0;
            for (int i = 0; i < array.length; i++) {
                size += array[i].length;
            }
        int[] lineArray = new int[size];
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    lineArray[counter] = array[i][j];
                    counter++;
                }
            }
        return lineArray;
    }
}
