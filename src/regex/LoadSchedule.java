package regex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class LoadSchedule {

    private static final File FILE_DIRECTORY = new File("src" + File.separator + "regex");

    public static void loadSchedule(Schedule schedule, String fileName) {
        File file = new File(FILE_DIRECTORY, fileName);
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(file)))) {
            while (scanner.hasNextLine()) {
                schedule.getSchedule().add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}

