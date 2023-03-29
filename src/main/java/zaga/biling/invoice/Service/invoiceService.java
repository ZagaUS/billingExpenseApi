package zaga.biling.invoice.Service;

import java.util.List;

import javax.ws.rs.core.Response;

import zaga.biling.invoice.Model.Invoice;

public interface invoiceService {
    Invoice addInvoice(Invoice invoice);

    List<Invoice> getAllInvoice();

    Response editInvoice(Invoice invoice);

    Response deleteInvoice(String invoiceId);


}
