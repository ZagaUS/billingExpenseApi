package zaga.biling.invoice.service;

import java.util.List;

import javax.ws.rs.core.Response;

import zaga.biling.invoice.model.Invoice;
import zaga.biling.invoice.model.InvoiceDto;

public interface InvoiceService {
    Invoice addInvoice(Invoice invoice);

    List<Invoice> getAllInvoice();

    Invoice getInvoicebyId(String invoiceId);

    // Response editInvoice(Invoice invoice);

    Response deleteInvoice(String invoiceId);

    Invoice update(String id, Invoice invoice);

}
