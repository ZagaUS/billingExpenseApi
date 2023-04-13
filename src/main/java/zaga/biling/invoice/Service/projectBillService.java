package zaga.biling.invoice.service;

import java.util.List;

import javax.ws.rs.core.Response;

import zaga.biling.invoice.model.ProjectBill;

public interface ProjectBillService {

    List<ProjectBill> getAllProjectBill();

    ProjectBill addProjectBill(ProjectBill proBill);

    Response editProjectBill(ProjectBill proBill);

    Response deleteProjectBill(String projectId);

}
