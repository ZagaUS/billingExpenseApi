package zaga.biling.invoice.Service;

import java.time.LocalDate;
import java.util.List;

import zaga.biling.invoice.Model.ProjectDetails;
import zaga.biling.invoice.Model.WeeklyTimesheet;

public interface ProjectDetailsInvoiceService {
    
//public ProjectDetails getbyprojectName(String projectName,LocalDate startDate,LocalDate endDate );

public WeeklyTimesheet generateWeeeklyTimesheet(String projectName, LocalDate startDate, LocalDate endDate);

//public List<ProjectDetails> getAllProjectDetails();
}
