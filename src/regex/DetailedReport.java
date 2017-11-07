package regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetailedReport implements Generatable {

    private List<String> array = new ArrayList<>();

    @Override
    public void generate(Schedule schedule, String fileName) {
        durationCount(schedule);
        WriteDetailedReport.write(array, fileName);
    }

    private void durationCount(Schedule schedule) {
        StringBuffer stringBuffer = new StringBuffer();
        Pattern activityPattern = Pattern.compile("(\\d{2}):(\\d{2})([\\sа-яА-Я]*)(\\d{2}):(\\d{2})([\\sа-яА-Я]*)");
        Pattern endDayPattern = Pattern.compile("Конец");
        for (String line : schedule.getSchedule()) {
            stringBuffer.append(line);
            Matcher endDayMatcher = endDayPattern.matcher(stringBuffer);
            Matcher activityMatcher = activityPattern.matcher(stringBuffer);
            if (activityMatcher.find()) {
                String time = activityMatcher.group(4) + ":" + activityMatcher.group(5);
                String activity = activityMatcher.group(6);
                int start = Integer.valueOf(activityMatcher.group(1)) * 60 + Integer.valueOf(activityMatcher.group(2));
                int end = Integer.valueOf(activityMatcher.group(4)) * 60 + Integer.valueOf(activityMatcher.group(5));
                array.add(activityMatcher.group(3) + " " + (end - start));
                if (endDayMatcher.find()) {
                    stringBuffer.delete(0, stringBuffer.length());
                    array.add("Конец дня");
                    continue;
                }
                stringBuffer.delete(0, stringBuffer.length());
                stringBuffer.append(time).append(activity);
            }
        }
    }
}
