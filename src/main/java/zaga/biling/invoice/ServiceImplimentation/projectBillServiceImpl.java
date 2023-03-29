package zaga.biling.invoice.ServiceImplimentation;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import zaga.biling.invoice.Model.ProjectBill;
import zaga.biling.invoice.Repo.projectBilRepo;
import zaga.biling.invoice.Service.projectBillService;

@ApplicationScoped
public class projectBillServiceImpl implements projectBillService{


    @Inject 
    projectBilRepo proRepo;

    @Override
    public List<ProjectBill> getAllProjectBill() {
        List<ProjectBill> projectBill = proRepo.getProjectBillDetails();
        return projectBill;
    }

    @Override
    public ProjectBill addProjectBill(ProjectBill proBill) {
        ProjectBill.persist(proBill);
        return proBill;
    }

    @Override
    public Response editProjectBill(ProjectBill proBill) {
        proRepo.findbyProjectId(proBill);
        return Response.status(Response.Status.OK).build();
    }

    @Override
    public Response deleteProjectBill(String projectId) {
        proRepo.deleteProjectBillById(projectId);
        return Response.status(Response.Status.OK).build();
    }

    @Override
    public Response CalculateInvoiceAmt(ProjectBill proBill) {
        proRepo.getInvoiceAmt(proBill);
        proRepo.updateInvoiceAmount(proBill);
        return Response.status(Response.Status.OK).build();
    }

    
}
