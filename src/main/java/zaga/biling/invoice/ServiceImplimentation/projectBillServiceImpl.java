package zaga.biling.invoice.serviceimplimentation;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import zaga.biling.invoice.model.ProjectBill;
import zaga.biling.invoice.repo.ProjectBilRepo;
import zaga.biling.invoice.service.ProjectBillService;

@ApplicationScoped
public class ProjectBillServiceImpl implements ProjectBillService {

    @Inject
    ProjectBilRepo proRepo;

    @Override
    public List<ProjectBill> getAllProjectBill() {
        List<ProjectBill> projectBill = proRepo.getProjectBillDetails();
        return projectBill;
    }

    @Override
    public ProjectBill addProjectBill(ProjectBill proBill) {
        // proRepo.getInvoiceAmt(proBill);

        String md = proBill.getMd();
        String bilRate = proBill.getBilRate();
        String invoiceAmt = proBill.getInvoiceAmount();

        int manday = Integer.parseInt(md);
        int billrate = Integer.parseInt(bilRate);
        int invoiceamt = Integer.parseInt(invoiceAmt);

        invoiceamt = manday * billrate;

        String invoice = String.valueOf(invoiceamt);
        proBill.setInvoiceAmount(invoice);
        proRepo.updateInvoiceAmount(proBill);

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

    // public String getInvoiceAmt(ProjectBill projectBill)
    // {
    // System.out.println("InvoiceAmt: " + projectBill.getInvoiceAmount());
    // String md = projectBill.getMd();
    // String bilRate = projectBill.getBilRate();
    // String invoiceAmt = projectBill.getInvoiceAmount();

    // int manday=Integer.parseInt(md);
    // int billrate = Integer.parseInt(bilRate);
    // int invoiceamt = Integer.parseInt(invoiceAmt);

    // invoiceamt = manday*billrate;
    // System.out.println("invoiceamt"+invoiceamt);
    // String invoice=String.valueOf(invoiceamt);
    // projectBill.setInvoiceAmount(invoice);
    // System.out.println("InvoiceAmt"+invoice);
    // return invoice;
    // }

    // @Override
    // public Response CalculateInvoiceAmt(ProjectBill proBill) {
    // proRepo.getInvoiceAmt(proBill);
    // proRepo.updateInvoiceAmount(proBill);
    // return Response.status(Response.Status.OK).build();
    // }

}
