package zaga.biling.invoice.Repo;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.mongodb.panache.PanacheQuery;
import zaga.biling.invoice.Model.Invoice;

@ApplicationScoped
public class invoiceRepo implements PanacheMongoRepository<Invoice> {

    public List<Invoice> getInvoiceDetails() {
        List<Invoice> invo = Invoice.listAll();
        return invo;
    }


    public List<Invoice> getInvoiceDetails(String projectId) {
        List<Invoice> invo = Invoice.list("projectId=?1", projectId);
        return invo;
    }


    // public Invoice findbyInvoiceId(Invoice invoice) {
    // String invoiceId = invoice.getInvoiceId();
    // PanacheQuery<Invoice> edit = Invoice.find("invoiceId = ?1 ", invoiceId);
    // Invoice i = edit.firstResult();
    // i.setInvoiceId(invoice.getInvoiceId());
    // i.setProjectName(invoice.getProjectName());
    // i.setDate(invoice.getDate());
    // i.setClientAddress(invoice.getClientAddress());
    // i.setConsultant(invoice.getConsultant());
    // i.setNote(invoice.getNote());
    // Invoice.update(i);
    // return i;
    // }

    public Long deleteInvoiceById(String invoiceId) {
        System.out.println("invoiceRepo" + invoiceId);
        return Invoice.delete("invoiceId", invoiceId.toString());
    }

    public Invoice findbyInvoiceId(String invoiceId) {

        System.out.println("repo");
        return find("invoiceId", invoiceId).firstResult();
    }
}
