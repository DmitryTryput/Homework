import java.util.Arrays;

public class ArrayLoop {

    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = i;
        }
        System.out.println(Arrays.toString(array));
        cycleShift(array);
        System.out.println(Arrays.toString(array));
    }

    public static void cycleShift(int[] array) {
        int lastElement = array[array.length-1];
        for (int i = array.length - 2; i >= 0; i--) {
            array[i+1] = array[i];
        }
        array[0] = lastElement;
    }
}

