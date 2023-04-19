package zaga.biling.invoice.Service;

import java.util.List;

import javax.ws.rs.core.Response;

import zaga.biling.invoice.Model.ProjectBill;

public interface projectBillService {

    List<ProjectBill> getAllProjectBill();

    ProjectBill addProjectBill(ProjectBill proBill);

    Response editProjectBill(ProjectBill proBill);

    Response deleteProjectBill(String projectId);

}
