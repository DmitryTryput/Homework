package regex;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WriteDetailedReport {

    private static final File FILE_DIRECTORY = new File("src" + File.separator + "regex");

    public static void write(List<String> array, String fileName) {
        File file = new File(FILE_DIRECTORY, fileName);
        List<String> lectures = new ArrayList<>();
        int sumTime = 0;
        int breakTime = 0;
        int lunchTime = 0;
        int exercisesTime = 0;
        int solutionsTime = 0;
        int lectureTime = 0;
        Pattern activityPattern = Pattern.compile("([а-яА-Я\\s]*)(\\d+)");
        try (BufferedWriter bufferedOutputStream = new BufferedWriter(new FileWriter(file))) {
            for (String line : array) {
                Matcher activityMatcher = activityPattern.matcher(line.trim());
                if (activityMatcher.find()) {
                    sumTime += Integer.valueOf(activityMatcher.group(2));
                    if (line.contains("Упражнения")) {
                        breakTime += Integer.valueOf(activityMatcher.group(2));
                    } else if (line.contains("Перерыв")) {
                        exercisesTime += Integer.valueOf(activityMatcher.group(2));
                    } else if (line.contains("Решения")) {
                        solutionsTime += Integer.valueOf(activityMatcher.group(2));
                    } else if (line.contains("Обеденный перерыв")) {
                        lunchTime += Integer.valueOf(activityMatcher.group(2));
                    } else {
                        lectureTime += Integer.valueOf(activityMatcher.group(2));
                        lectures.add(line);
                    }
                } else {
                    bufferedOutputStream.write("Лекции: " + lectureTime + " "
                            + (int)((double)lectureTime / sumTime * 100) + "%\n");
                    bufferedOutputStream.write("Упражнения: " + exercisesTime + " "
                            + (int)((double)exercisesTime / sumTime * 100) + "%\n");
                    bufferedOutputStream.write("Перерыв: " + breakTime + " "
                            + (int)((double)breakTime / sumTime * 100) + "%\n");
                    bufferedOutputStream.write("Решения: " + solutionsTime + " "
                            + (int)((double)solutionsTime / sumTime * 100) + "%\n");
                    bufferedOutputStream.write("Обеденный перерыв: " + lunchTime + " "
                            + (int)((double)lunchTime / sumTime * 100) + "%\n");
                    bufferedOutputStream.write("...\n");
                    bufferedOutputStream.write("Лекции:\n");
                    for (String lecture : lectures) {
                        Matcher lectureMatcher = activityPattern.matcher(lecture);
                        if (lectureMatcher.find()) {
                            String title = lectureMatcher.group(1);
                            int time = Integer.valueOf(lectureMatcher.group(2));
                            bufferedOutputStream.write(title + ": " + time + " " +
                                    (int)((double) time / sumTime * 100) + "%\n");
                        }
                    }
                    bufferedOutputStream.write("\n");
                    sumTime = 0;
                    breakTime = 0;
                    lunchTime = 0;
                    exercisesTime = 0;
                    solutionsTime = 0;
                    lectureTime = 0;
                    lectures.clear();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
