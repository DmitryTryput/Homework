package regex;

public class TestRegex {

    public static void main(String[] args) {
        Schedule schedule = new Schedule();
        LoadSchedule.loadSchedule(schedule, "log-file.txt");
        PeriodicReport periodicReport = new PeriodicReport();
        periodicReport.generate(schedule, "periodicalReport.txt");
        DetailedReport detailedReport = new DetailedReport();
        detailedReport.generate(schedule, "detailedReport.txt");
    }
}
