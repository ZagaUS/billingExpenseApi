package zaga.biling.invoice.client;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import zaga.biling.invoice.Model.Invoice;

@RegisterRestClient(configKey = "pdf-api")
public interface PdfService {

    @GET
    @Path("/{amount}")
    public Response generatePdf(@PathParam("amount") String amount);

    @POST
    @Path("/createInvoice")
    public Response generateInvoicePdf(Invoice invoice);

}
