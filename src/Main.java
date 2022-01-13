import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

class Main {

  /**
   * Calculates what role an employee had per given set of dates
   * @param timeline timeline events sorted by the effectiveFrom property in descending order
   * @param dates list of dates
   */
  private static Map<LocalDate, TimelineEvent> timelineEventsByDates(List<TimelineEvent> timeline, List<LocalDate> dates) {
    return null;
  }

  public static void main(String[] args) {
    List<TimelineEvent> timeline = Arrays.asList(
        new TimelineEvent("Team Leader", LocalDate.of(2020, 8, 1)),
        new TimelineEvent("Fullstack developer", LocalDate.of(2016, 5, 15)),
        new TimelineEvent("Frontend developer", LocalDate.of(2015, 11, 17))
    );

    List<LocalDate> dates = Arrays.asList(
        LocalDate.of(2021, 1, 1),
        LocalDate.of(2014, 1, 1),
        LocalDate.of(2016, 6, 1)
    );

    Map<LocalDate, TimelineEvent> rolesByDates = timelineEventsByDates(timeline, dates);

    rolesByDates.forEach((key, value) -> System.out.println(String.format("%s - %s", key, value.getTitle())));

  }

}