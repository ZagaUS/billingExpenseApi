package zaga.biling.invoice.Repo;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import zaga.biling.invoice.Model.DailyTimesheet;

@ApplicationScoped
public class DailyTimesheetRepository implements PanacheMongoRepository<DailyTimesheet> {

    public List<DailyTimesheet> getDailyTimesheetsByprojectName(String projectName) {
        List<DailyTimesheet> dt = DailyTimesheet.list("projectName=?1", projectName);
        return dt;
    }
    
}
