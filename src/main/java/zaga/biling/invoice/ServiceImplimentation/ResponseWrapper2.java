package zaga.biling.invoice.ServiceImplimentation;

import zaga.biling.invoice.Model.Invoice;
import zaga.biling.invoice.Model.PdfEntity;
import zaga.biling.invoice.Model.ProjectDetails;
import zaga.biling.invoice.Model.WeeklyTimesheet;

public class ResponseWrapper2 {
    private ProjectDetails projectDetails;
    private WeeklyTimesheet weeklyTimesheet;

    public ResponseWrapper2(ProjectDetails projectDetails, WeeklyTimesheet weeklyTimesheet) {
        this.projectDetails = projectDetails;
        this.weeklyTimesheet = weeklyTimesheet;
    }

    public ProjectDetails getProjectDetails() {
        return projectDetails;
    }

    public WeeklyTimesheet getWeeklyTimesheet() {
        return weeklyTimesheet;
    }

}
