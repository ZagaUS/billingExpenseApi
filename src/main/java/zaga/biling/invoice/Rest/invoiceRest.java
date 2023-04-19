package zaga.biling.invoice.Rest;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bson.types.Binary;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import zaga.biling.invoice.client.PdfService;
import zaga.biling.invoice.Model.Invoice;
import zaga.biling.invoice.Model.PdfEntity;
import zaga.biling.invoice.Repo.PdfRepository;
import zaga.biling.invoice.Service.invoiceService;

@Path("/Zaga/Invoice")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class invoiceRest {

    @Inject
    invoiceService inService;

    @Inject
    @RestClient
    PdfService pdfService;

    @Inject
    PdfRepository pdfRepository;

    @GET
    @Path("/getAllInvoices")
    @Operation(description = "Get all invoices")
    public Response getInvoices() {
        try {
            List<Invoice> invoices = inService.getAllInvoice();
            return Response.status(Response.Status.OK).entity(invoices).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Operation(description = "Creating a new invoice")
    // public Response createInvoice(Invoice invoice) {
    // try {
    // Invoice invoiceNew = inService.addInvoice(invoice);
    // return Response.status(Response.Status.OK).entity(invoiceNew).build();
    // } catch (Exception e) {
    // return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    // }
    // }

    // @POST
    // @Path("/updateInvoice")
    // @Operation(description = "Updating the invoice")
    // public Response updateInvoice(Invoice invoice) {
    // try {

    // return inService.editInvoice(invoice);
    // } catch (Exception e) {
    // return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();

    // }

    // }

    @DELETE
    @Path("/deleteInvoice")
    @Operation(description = "Deleting a invoice by its ID")
    public Response deleteInvoice(String invoiceId) {
        try {
            // System.out.println("invoiceRest" + invoiceId);
            return inService.deleteInvoice(invoiceId);
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PUT
    @Path("/updateInvoiceData/{invoiceId}")
    @Operation(description = "update a invoice by its invoiceId")
    public Response updateInvoicePdf(@PathParam("invoiceId") String invoiceId, Invoice invoice) {
        try {
            System.out.println("Resource");
            inService.update(invoiceId, invoice);
            return Response.ok(invoice).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/createInvoicee/pdf")
    public Response generateInvoicePdf(Invoice invoice) throws IOException {

        try {
            PdfEntity pdfDocument = new PdfEntity();
            pdfDocument.setProjectId("");

            Response response = pdfService.generateInvoicePdf(invoice);

            byte[] pdfBytes = response.readEntity(byte[].class);
            InputStream inputStream = new ByteArrayInputStream(pdfBytes);

            pdfDocument.setData(new Binary(inputStream.readAllBytes()));

            Invoice invoiceNew = inService.addInvoice(invoice);

            pdfRepository.persist(pdfDocument);
            return Response.ok(pdfDocument).build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GET
    @Path("/getInvoices/{id}")
    public Response getById(@PathParam("id") String invoiceId) {
        try {
            Invoice invoice = inService.getInvoicebyId(invoiceId);
            return Response.status(Response.Status.OK).entity(invoice).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
