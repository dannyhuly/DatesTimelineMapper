import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Main {

  /**
   * Calculates what role an employee had per given set of dates
   * @param timeline timeline events sorted by the effectiveFrom property in descending order
   * @param dates list of dates
   */
  private static Map<LocalDate, TimelineEvent> timelineEventsByDates(List<TimelineEvent> timeline, List<LocalDate> dates) {
    List<LocalDate> sortedDates = dates
        .stream()
        .sorted((a, b) -> a.isAfter(b) ? 1 : -1)
        .collect(Collectors.toList());

    Collections.reverse(timeline);

    Map<LocalDate, TimelineEvent> rolesByDatesRes = new HashMap<>();
    int datesPointer = 0;
    int timelinePointer = 0;

    // before first event
    while (datesPointer < sortedDates.size()) {
      if (sortedDates.get(datesPointer).isBefore(timeline.get(timelinePointer).getEffectiveFrom()) ) {
        rolesByDatesRes.put(sortedDates.get(datesPointer), new TimelineEvent("unknown", sortedDates.get(datesPointer)));
        datesPointer++;
      } else {
        break;
      }
    }

    // check dates between events
    while (timelinePointer < timeline.size()-1) {
      if (sortedDates.get(datesPointer).isAfter(timeline.get(timelinePointer).getEffectiveFrom()) &&
          sortedDates.get(datesPointer).isBefore(timeline.get(timelinePointer+1).getEffectiveFrom())) {

        rolesByDatesRes.put(sortedDates.get(datesPointer), timeline.get(timelinePointer));
        datesPointer++;
      }
      timelinePointer++;
    }

    // after last events)
    while (datesPointer < sortedDates.size()) {
      rolesByDatesRes.put(sortedDates.get(datesPointer), timeline.get(timelinePointer));
      datesPointer++;
    }

    return rolesByDatesRes;
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