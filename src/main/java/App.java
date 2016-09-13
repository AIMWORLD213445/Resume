import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.time.LocalDate;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    post("/jobs", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();

    ArrayList<Job> jobs = request.session().attribute("jobs");
    if (jobs == null) {
      jobs = new ArrayList<Job>();
      request.session().attribute("jobs", jobs);
    }

    String companyName = request.queryParams("companyName");
    LocalDate startDate = stringToLocalDate(request.queryParams("startDate"));
    LocalDate endDate = stringToLocalDate(request.queryParams("endDate"));
    String description = request.queryParams("description");
    Job newJob = new Job(companyName, startDate, endDate, description);
    jobs.add(newJob);

    model.put("template", "templates/success.vtl");
    return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());
   get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("jobs", request.session().attribute("jobs"));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }

  public static LocalDate stringToLocalDate(String dateIn) {
    String[] dateToConvert = dateIn.split("-");
    Integer[] newDate = new Integer[3];
    for (int i = 0; i < 3; i++) {
      newDate[i] = Integer.parseInt(dateToConvert[i]);
    }
    LocalDate output = LocalDate.of(newDate[0], newDate[1], newDate[2]);
    return output;
  }
}
