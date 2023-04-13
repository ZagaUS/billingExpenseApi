package zaga.biling.invoice.client;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import zaga.biling.invoice.model.Invoice;
import zaga.biling.invoice.model.InvoiceDto;

@RegisterRestClient()
public interface PdfService {

    @GET
    @Path("/{amount}")
    public Response generatePdf(@PathParam("amount") String amount);

    @POST
    @Path("/createInvoice")
    public Response generateInvoicePdf(Invoice invoice);

}
