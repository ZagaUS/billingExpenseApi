package zaga.biling.invoice.ServiceImplimentation;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import zaga.biling.invoice.Model.DailyTimesheet;
import zaga.biling.invoice.Model.ProjectDetails;
import zaga.biling.invoice.Model.WeeklyTimesheet;
import zaga.biling.invoice.Repo.DailyTimesheetRepository;
import zaga.biling.invoice.Repo.ProjectDetailsInvoiceRepo;
import zaga.biling.invoice.Service.ProjectDetailsInvoiceService;

@ApplicationScoped
public class ProjectDetailsServiceImple implements ProjectDetailsInvoiceService {
  
@Inject
ProjectDetailsInvoiceRepo repo;

@Inject
DailyTimesheetRepository drepo;


// @Override
// public ProjectDetails getbyprojectName(String projectName,LocalDate startDate,LocalDate endDate ) {
//     return repo.findbyProjectName(projectName, endDate, endDate);
// }


@Override
public WeeklyTimesheet generateWeeeklyTimesheet(String projectName, LocalDate startDate, LocalDate endDate) {

    WeeklyTimesheet result = new WeeklyTimesheet();

    List<DailyTimesheet> data = drepo.getDailyTimesheetsByprojectName(projectName);

    System.out.println(data);

    List<DailyTimesheet> filteredData = data.stream()
    .filter(timesheet -> timesheet.getDate().isAfter(startDate.minusDays(1))
            && timesheet.getDate().isBefore(endDate.plusDays(1)))
    .collect(Collectors.toList());

    Double sum = filteredData.stream()
    .mapToDouble(DailyTimesheet::getHours)
    .sum();

    System.out.println(filteredData.size());

    Double manDays = (double) filteredData.size();

    result.setTimesheets(filteredData);
        result.setProjectName(projectName);
        result.setStartDate(startDate);
        result.setEndDate(endDate);
        result.setDuration(manDays);
        System.out.println(result);
        return result;

}


// @Override
// public List<ProjectDetails> getAllProjectDetails() {
//     return repo.listAll();
// }

   


}
