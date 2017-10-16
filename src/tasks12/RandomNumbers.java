package tasks12;

import java.io.*;
import java.util.*;

public class RandomNumbers {

    public static void main(String[] args) {
        File file = createFile("numbers.txt");
        generateNumbers(file,1000);
        sortInFile(file);
    }

    public static File createFile(String name) {
        File dir = new File("src" + File.separator +"tasks12");
        dir.isDirectory();
        File file = new File(dir, name);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public static void generateNumbers(File file, int numbersCount) {
        try (BufferedWriter bufferedOutputStream = new BufferedWriter(new FileWriter(file))) {
            Random random = new Random();
            for (int i = 0; i < numbersCount; i++) {
                bufferedOutputStream.write(random.nextInt() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sortInFile(File file) {
        List<Integer> setOfNumbers = new ArrayList<>();
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(file)))) {
            while (scanner.hasNextInt()) {
                setOfNumbers.add(scanner.nextInt());
            }
            Collections.sort(setOfNumbers);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter bufferedOutputStream = new BufferedWriter(new FileWriter(file))) {
            for (int number : setOfNumbers) {
                bufferedOutputStream.write(number + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

