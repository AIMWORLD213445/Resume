import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Job {
  private String mCompanyName;
  private LocalDate mStartDate;
  private LocalDate mEndDate;
  private String mDescription;

  public Job(String companyName, LocalDate startDate, LocalDate endDate, String description) {
    mCompanyName = companyName;
    mStartDate = startDate;
    mEndDate = endDate;
    mDescription = description;
  }

  public String getCompanyName() {
    return mCompanyName;
  }

  public LocalDate getStartDate() {
    return mStartDate;
  }

  public LocalDate getEndDate() {
    return mEndDate;
  }

  public String getDescription() {
    return mDescription;
  }

  public long getJobDuration() {
    return ChronoUnit.MONTHS.between(mStartDate, mEndDate);
  }

}
