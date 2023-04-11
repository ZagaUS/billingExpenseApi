package zaga.biling.invoice.Service;

import java.util.List;

import javax.ws.rs.core.Response;

import zaga.biling.invoice.Model.Invoice;
import zaga.biling.invoice.Model.InvoiceDto;

public interface InvoiceService {
    Invoice addInvoice(Invoice invoice);

    List<Invoice> getAllInvoice();

    Response editInvoice(Invoice invoice);

    Response deleteInvoice(String invoiceId);

    InvoiceDto update(String id, InvoiceDto invoiceDto);

}
