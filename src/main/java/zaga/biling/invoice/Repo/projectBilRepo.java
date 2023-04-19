package zaga.biling.invoice.Repo;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.mongodb.panache.PanacheQuery;
import zaga.biling.invoice.Model.ProjectBill;

@ApplicationScoped
public class projectBilRepo implements PanacheMongoRepository<ProjectBill> {

    public List<ProjectBill> getProjectBillDetails() {
        List<ProjectBill> pro = ProjectBill.listAll();
        return pro;
    }

    public ProjectBill findbyProjectId(ProjectBill proedit) {
        String projectId = proedit.getProjectId();
        PanacheQuery<ProjectBill> editBil = ProjectBill.find("projectId = ?1 ", projectId);
        ProjectBill p = editBil.firstResult();

        p.setBilRate(proedit.getBilRate());
        p.setDuration(proedit.getDuration());
        p.setMd(proedit.getMd());
        p.setPa(proedit.getPa());
        p.setPo(proedit.getPo());
        p.setInvoiceAmount(proedit.getInvoiceAmount());
        p.setTotalMd(proedit.getTotalMd());
        ProjectBill.update(p);
        return p;
    }

    public Long deleteProjectBillById(String projectId) {
        System.out.println("projectid inside Repo" + projectId);
        return ProjectBill.delete("projectId", projectId.toString());
    }

    // public String getInvoiceAmt(String md,String bilRate,String invoiceAmount) {
    // }

    public String getInvoiceAmt(ProjectBill projectBill) {
        System.out.println("InvoiceAmt: " + projectBill.getInvoiceAmount());
        String md = projectBill.getMd();
        String bilRate = projectBill.getBilRate();
        String invoiceAmt = projectBill.getInvoiceAmount();

        int manday = Integer.parseInt(md);
        int billrate = Integer.parseInt(bilRate);
        int invoiceamt = Integer.parseInt(invoiceAmt);

        invoiceamt = manday * billrate;
        System.out.println("invoiceamt" + invoiceamt);
        String invoice = String.valueOf(invoiceamt);
        projectBill.setInvoiceAmount(invoice);
        System.out.println("InvoiceAmt" + invoice);
        return invoice;
    }

    public ProjectBill updateInvoiceAmount(ProjectBill proedit) {
        String projectId = proedit.getProjectId();
        PanacheQuery<ProjectBill> editBil = ProjectBill.find("projectId = ?1 ", projectId);
        ProjectBill p = editBil.firstResult();
        p.setInvoiceAmount(proedit.getInvoiceAmount());
        ProjectBill.update(p);
        return p;
    }
}
