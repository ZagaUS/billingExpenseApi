package zaga.biling.invoice.Rest;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
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
import zaga.biling.invoice.Repo.SequenceRepository;
import zaga.biling.invoice.Service.invoiceService;
import zaga.biling.invoice.ServiceImplimentation.ResponseWrapper;

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

    @Inject
    SequenceRepository seqRepo;

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

    @DELETE
    @Path("/deleteInvoice/{invoiceId}")
    @Operation(description = "Deleting a invoice by its ID")
    public Response deleteInvoice(String invoiceId) {
        try {
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
      System.out.println("Invioce"+invoice);
        try {
            PdfEntity pdfDocument = new PdfEntity();
            pdfDocument.setProjectId("");
            // invoice id
            String seqNo = seqRepo.getSequenceCounter("invoice");
            StringBuilder invoiceId = new StringBuilder();
            invoiceId.append(invoice.projectName);
            invoiceId.append("_");
            invoiceId.append(seqNo);
            invoice.setInvoiceId(invoiceId.toString());
            invoice.setNote("service done virtually");

            // doc id
            String documentseqNo = seqRepo.getSequenceCounter("document");

            StringBuilder docId = new StringBuilder();
            docId.append(invoice.projectName);
            docId.append("_");
            docId.append(invoice.date);
            docId.append("_");
            docId.append(documentseqNo);
            // duration wrapping
            StringBuilder duration = new StringBuilder();
            duration.append(invoice.startDate);
            duration.append("-");
            duration.append(invoice.endDate);
            invoice.setDuration(duration.toString());

            Float invoiceAmount = invoice.manHours * invoice.rate;
            invoice.setInvoiceAmount(invoiceAmount);
            invoice.setTotalInvoiceAmount(invoiceAmount);

            // Setting PdfEntity properties
            pdfDocument.setDocumentId(docId.toString());
            pdfDocument.projectId = invoice.projectId;
            pdfDocument.projectName = invoice.projectName;
            pdfDocument.startDate = invoice.startDate;
            pdfDocument.endDate = invoice.endDate;
            invoice.setDocumentId(docId.toString());
            Response response = pdfService.generateInvoicePdf(invoice);

            byte[] pdfBytes = response.readEntity(byte[].class);
            InputStream inputStream = new ByteArrayInputStream(pdfBytes);

            pdfDocument.setData(new Binary(inputStream.readAllBytes()));

            Invoice invoiceNew = inService.addInvoice(invoice);

            pdfRepository.persist(pdfDocument);
            ResponseWrapper responseWrapper = new ResponseWrapper(pdfDocument, invoiceNew);
            return Response.ok(responseWrapper).build();

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

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/invoice/{documentId}/pdf")
    public Response getInvoicePdfById(@PathParam("documentId") String documentId) {
        try {
            PdfEntity pdfDocument = pdfRepository.findById(documentId);

            if (pdfDocument == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            String string = Base64.getEncoder().encodeToString(pdfDocument.getData().getData());
            // byte[] pdfBytes = pdfDocument.getData().getData();
            // InputStream inputStream = new ByteArrayInputStream(pdfBytes);

            return Response.ok(string).build();
            // .type("application/pdf")
            // .header("Content-Disposition", "attachment; filename=invoice.pdf")
            // .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

}
