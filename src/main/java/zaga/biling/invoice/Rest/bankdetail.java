package zaga.biling.invoice.Rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import javax.inject.Inject;

import org.eclipse.microprofile.openapi.annotations.Operation;

import zaga.biling.invoice.Model.BankDetail;
import zaga.biling.invoice.Model.Invoice;
import zaga.biling.invoice.Service.bankDetailService;
import zaga.biling.invoice.Service.invoiceService;

@Path("/Zaga/Invoice")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class bankdetail {

    @Inject
    bankDetailService bService;

    @POST
    @Path(value = "/createBankDetails")
    @Operation(description = "create the bank details")
    public Response createBankDetails(BankDetail bDetail)
    {
        try{
            BankDetail bDetailNew = bService.getBankDetail(bDetail);
            return Response.status(Response.Status.OK).entity(bDetailNew).build();
        }
        catch(Exception e){
            {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            }
    }
    
}
}
