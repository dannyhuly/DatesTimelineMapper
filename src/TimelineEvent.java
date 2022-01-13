import java.time.LocalDate;
import java.util.Objects;

class TimelineEvent {
  private String title;
  private LocalDate effectiveFrom;

  public TimelineEvent(String title, LocalDate effectiveFrom) {
    this.title = title;
    this.effectiveFrom = effectiveFrom;
  }

  public String getTitle() {
    return title;
  }

  public LocalDate getEffectiveFrom() {
    return effectiveFrom;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TimelineEvent timelineEvent = (TimelineEvent) o;
    return Objects.equals(title, timelineEvent.title) &&
        Objects.equals(effectiveFrom, timelineEvent.effectiveFrom);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, effectiveFrom);
  }
}