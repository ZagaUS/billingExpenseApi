package zaga.biling.invoice.ServiceImplimentation;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import zaga.biling.invoice.Model.Invoice;
import zaga.biling.invoice.Repo.InvoiceRepo;
import zaga.biling.invoice.Repo.SequenceRepository;
import zaga.biling.invoice.Service.InvoiceService;

@ApplicationScoped
public class InvoiceServiceImpl implements InvoiceService {

    @Inject
    InvoiceRepo inrepo;

    @Inject
    SequenceRepository seqRepo;

    @Override
    public Invoice addInvoice(Invoice invoice) {
        System.out.println("Invoice inside service");

        String seqNo = seqRepo.getSequenceCounter("invoice");
        invoice.setInvoiceId(seqNo);

        inrepo.persist(invoice);
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
        System.out.println("invoiceService" + invoiceId);
        inrepo.deleteInvoiceById(invoiceId);
        return Response.status(Response.Status.OK).build();
    }
}
