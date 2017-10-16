package tasks12;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CharsCount {

    public static void main(String[] args) {
        File dir = new File("src" + File.separator + "tasks12");
        dir.isDirectory();
        File input = new File(dir,"poem.txt");
        File output = new File(dir,"result.txt");
        charCount(input, output);
    }

    public static void charCount(File text, File result) {
        String stringOfChars = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        List<String> textArray = new ArrayList<>();
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(text)));
                BufferedWriter bufferedOutputStream = new BufferedWriter(new FileWriter(result))) {
            while (scanner.hasNextLine()) {
                textArray.add(scanner.nextLine().toLowerCase());
            }
            for (char countChar : stringOfChars.toCharArray()) {
                int counter = 0;
                for (String line : textArray) {
                    for (char textChar : line.toCharArray()) {
                        if (countChar == textChar) {
                            counter++;
                        }
                    }
                }
                bufferedOutputStream.write(countChar + " - " + counter + "\n");
            }
        } catch (IOException e) {
                e.printStackTrace();
        }
    }
}


