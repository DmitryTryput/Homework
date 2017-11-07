package regex;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PeriodicReport implements Generatable {

    private static final File FILE_DIRECTORY = new File("src" + File.separator + "regex");

    @Override
    public void generate(Schedule schedule, String fileName) {
        File file = new File(FILE_DIRECTORY, fileName);
        StringBuffer stringBuffer = new StringBuffer();
        Pattern activityPattern = Pattern.compile("(\\d{2}:\\d{2})([\\sа-яА-Я]*)(\\d{2}:\\d{2})([\\sа-яА-Я]*)");
        Pattern endDayPattern = Pattern.compile("Конец");
        try (BufferedWriter bufferedOutputStream = new BufferedWriter(new FileWriter(file))) {
            for (String line : schedule.getSchedule()) {
                stringBuffer.append(line);
                Matcher endDayMatcher = endDayPattern.matcher(stringBuffer);
                Matcher activityMatcher = activityPattern.matcher(stringBuffer);
                if (activityMatcher.find()) {
                    String time = activityMatcher.group(3);
                    String activity = activityMatcher.group(4);
                    bufferedOutputStream.write(activityMatcher.group(1) + "-" + time
                            + activityMatcher.group(2) + "\n");
                    if (endDayMatcher.find()) {
                        bufferedOutputStream.write("\n");
                        stringBuffer.delete(0, stringBuffer.length());
                        continue;
                    }
                    stringBuffer.delete(0, stringBuffer.length());
                    stringBuffer.append(time).append(activity);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
