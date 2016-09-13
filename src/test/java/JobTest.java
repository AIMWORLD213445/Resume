import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class JobTest {

  @Test
  public void Job_instaniatesCorrectly_true() {
    String jobName = "Epicodus";
    LocalDate startDate = LocalDate.of(2016, Month.SEPTEMBER, 12);
    LocalDate endDate = LocalDate.of(2016, Month.SEPTEMBER, 13);
    String description = "Awesome coding student.";
    Job myJob = new Job(jobName, startDate, endDate, description);
    assertEquals(true, myJob instanceof Job);
  }

  @Test
  public void getCompanyName_returnsJobName_String() {
    String jobName = "Epicodus";
    LocalDate startDate = LocalDate.of(2016, Month.SEPTEMBER, 12);
    LocalDate endDate = LocalDate.of(2016, Month.SEPTEMBER, 13);
    String description = "Awesome coding student.";
    Job myJob = new Job(jobName, startDate, endDate, description);
    assertEquals("Epicodus", myJob.getCompanyName());
  }

  @Test
  public void getStartDate_returnsStartDate_LocalDate() {
    String jobName = "Epicodus";
    LocalDate startDate = LocalDate.of(2016, Month.SEPTEMBER, 12);
    LocalDate endDate = LocalDate.of(2016, Month.SEPTEMBER, 13);
    String description = "Awesome coding student.";
    Job myJob = new Job(jobName, startDate, endDate, description);
    LocalDate expected = LocalDate.of(2016, Month.SEPTEMBER, 12);
    assertEquals(expected, myJob.getStartDate());
  }

  @Test
  public void getEndDate_returnsEndDate_LocalDate() {
    String jobName = "Epicodus";
    LocalDate startDate = LocalDate.of(2016, Month.SEPTEMBER, 12);
    LocalDate endDate = LocalDate.of(2016, Month.SEPTEMBER, 13);
    String description = "Awesome coding student.";
    Job myJob = new Job(jobName, startDate, endDate, description);
    LocalDate expected = LocalDate.of(2016, Month.SEPTEMBER, 13);
    assertEquals(expected, myJob.getEndDate());
  }

  @Test
  public void getDescription_returnsDescription_String() {
    String jobName = "Epicodus";
    LocalDate startDate = LocalDate.of(2016, Month.SEPTEMBER, 12);
    LocalDate endDate = LocalDate.of(2016, Month.SEPTEMBER, 13);
    String description = "Awesome coding student.";
    Job myJob = new Job(jobName, startDate, endDate, description);
    assertEquals("Awesome coding student.", myJob.getDescription());
  }

  @Test
  public void getJobDuration_returnsTimeOnJob_Long() {
    String jobName = "Epicodus";
    LocalDate startDate = LocalDate.of(2016, Month.AUGUST, 12);
    LocalDate endDate = LocalDate.of(2016, Month.SEPTEMBER, 13);
    String description = "Awesome coding student.";
    Job myJob = new Job(jobName, startDate, endDate, description);
    long expected = ChronoUnit.MONTHS.between(startDate, endDate);
    assertEquals(expected, myJob.getJobDuration());
  }

}
