package zaga.biling.invoice.Rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;


import zaga.biling.invoice.Model.Invoice;
import zaga.biling.invoice.Service.InvoiceService;

@Path("/Zaga/Invoice")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class InvoiceRest {

@Inject
InvoiceService inService;


@GET
@Path("/getAllInvoices")
@Operation(description = "Get all invoices")
public Response getInvoices(){
    try{
       List<Invoice> invoices = inService.getAllInvoice();
       return Response.status(Response.Status.OK).entity(invoices).build();
    } catch(Exception e){
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
}

@POST
@Path("/createInvoice")
@Operation(description = "Creating a new invoice")
public Response createInvoice(Invoice invoice){
    // System.out.println("Invoice"+invoice);
    try {
        // System.out.println("Invoice inside try"+invoice);
        Invoice invoiceNew = inService.addInvoice(invoice);
        return Response.status(Response.Status.OK).entity(invoiceNew).build();
    } catch (Exception e) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
}


@POST
@Path("/updateInvoice")
@Operation(description = "Updating the invoice")
public Response updateInvoice(Invoice invoice){
    try {

        return inService.editInvoice(invoice);
    } catch (Exception e) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();

    }

}
@DELETE
@Path("/deleteInvoice")
@Operation(description = "Deleting a invoice by its ID")
public Response deleteInvoice(String invoiceId){
    try{
        System.out.println("invoiceRest"+invoiceId);
        return inService.deleteInvoice(invoiceId);
    }
    catch(Exception e) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
}

}
}