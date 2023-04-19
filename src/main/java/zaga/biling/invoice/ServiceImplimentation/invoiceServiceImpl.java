package zaga.biling.invoice.ServiceImplimentation;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;

import zaga.biling.invoice.Model.Invoice;
import zaga.biling.invoice.Repo.invoiceRepo;
import zaga.biling.invoice.Repo.SequenceRepository;
import zaga.biling.invoice.Service.invoiceService;

@ApplicationScoped
public class invoiceServiceImpl implements invoiceService {

    @Inject
    invoiceRepo inrepo;

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

    // @Override
    // public Response editInvoice(Invoice invoice) {
    // inrepo.findbyInvoiceId(invoice);
    // return Response.status(Response.Status.OK).build();
    // }

    @Override
    public Response deleteInvoice(String invoiceId) {
        System.out.println("invoiceService" + invoiceId);
        inrepo.deleteInvoiceById(invoiceId);
        return Response.status(Response.Status.OK).build();
    }

    @Override
    public Invoice update(String id, Invoice invoice) {
        System.out.println("service");
        Invoice existingInvoice = inrepo.findbyInvoiceId(id);
        if (existingInvoice == null) {
            throw new NotFoundException("Invoice not found");
        }
        existingInvoice.setDate(invoice.getDate());
        existingInvoice.setProjectName(invoice.getProjectName());
        existingInvoice.setConsultant(invoice.getConsultant());
        existingInvoice.setClientAddress(invoice.getClientAddress());
        existingInvoice.setNote(invoice.getNote());
        existingInvoice.setPayOrder(invoice.getPayOrder());
        existingInvoice.setSfdc(invoice.getSfdc());
        existingInvoice.setPa(invoice.getPa());
        existingInvoice.setTotalManDays(invoice.getTotalManDays());
        existingInvoice.setManDays(invoice.getManDays());
        existingInvoice.setInvoiceAmount(invoice.getInvoiceAmount());
        existingInvoice.setTotalInvoiceAmount(invoice.getTotalInvoiceAmount());
        inrepo.update(existingInvoice);
        return existingInvoice;
    }

    @Override
    public Invoice getInvoicebyId(String invoiceId) {
        System.out.println("service");
        return inrepo.findbyInvoiceId(invoiceId);
    }

}
