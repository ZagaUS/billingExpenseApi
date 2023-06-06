package zaga.biling.invoice.Rest;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

// import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import zaga.biling.invoice.Model.CreditNote;
import zaga.biling.invoice.Model.PdfEntity;
import zaga.biling.invoice.Repo.PdfRepository;
import zaga.biling.invoice.Service.CreditNoteService;
import zaga.biling.invoice.client.PdfService;


@Path("/Zaga/CreditNote")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CreditNoteRest {
    
    @Inject
    CreditNoteService service;

    @Inject
    @RestClient
    PdfService pdfService;

    @Inject
    PdfRepository pdfRepository;

    @GET
    @Path("/getCreditNotesByProjectId/{projectId}")
    @Operation(description = "Get all credit notes for a given project Id")
    public Response findCreditNoteByProjectId(@PathParam("projectId") String projectId) {
        try {
            List<CreditNote> creditNotes = service.findCreditNotesByProjectId(projectId);
            return Response.status(Response.Status.OK).entity(creditNotes).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    @Path("/deleteCreditNote/{documentId}")
    @Operation(description = "Deleting a credit note by its ID")
    public Response deleteCreditNote(@PathParam("documentId") String documentId) {
        try {
            return service.deleteCreditNote(documentId);
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

    }

    @POST
    @Path("/createCreditNote/pdf")
    public Response generateCreditNotePdf(CreditNote creditNote) throws IOException {
        service.generateCreditNote(creditNote);
        return Response.ok().build();

    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/creditNote/{documentId}/pdf")
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
