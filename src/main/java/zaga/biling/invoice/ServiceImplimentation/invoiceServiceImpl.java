package zaga.biling.invoice.ServiceImplimentation;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import zaga.biling.invoice.Model.Invoice;
import zaga.biling.invoice.Repo.invoiceRepo;
import zaga.biling.invoice.Service.invoiceService;

@ApplicationScoped
public class invoiceServiceImpl implements invoiceService {
    
    @Inject
    invoiceRepo inrepo;

    @Override
    public Invoice addInvoice(Invoice invoice) {
        Invoice.persist(invoice);
        // System.out.println("Invoice inside service"+invoice);
        return invoice;

}
    @Override
    public List<Invoice> getAllInvoice() {
        List<Invoice> invoices = inrepo.getInvoiceDetails();
        return invoices;
    }


    @Override
    public Response editInvoice(Invoice invoice) {
        inrepo.findbyInvoiceId(invoice);
        return Response.status(Response.Status.OK).build();
    }

    @Override
    public Response deleteInvoice(String invoiceId) {
        System.out.println("invoiceService"+invoiceId);
         inrepo.deleteInvoiceById(invoiceId);
         return Response.status(Response.Status.OK).build();
    }
}
