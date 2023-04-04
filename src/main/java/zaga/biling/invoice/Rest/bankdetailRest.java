package zaga.biling.invoice.Rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

import javax.inject.Inject;

import org.eclipse.microprofile.openapi.annotations.Operation;

import zaga.biling.invoice.Model.BankDetail;
import zaga.biling.invoice.Service.BankDetailService;


@Path("/Zaga/Invoice")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BankdetailRest {

    @Inject
    BankDetailService bService;

    @POST
    @Path(value = "/createBankDetails")
    @Operation(description = "create the bank details")
    public Response createBankDetails(BankDetail bDetail)
    {
        try{
            BankDetail bDetailNew = bService.addBankDetail(bDetail);
            return Response.status(Response.Status.OK).entity(bDetailNew).build();
        }
        catch(Exception e){
            {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            }
    }
    
}

@GET
@Path(value = "/getAllBankCredential")
@Operation(description ="Get all the bankDetails" )
public Response getAllBankDetails()
{
    try{
        List<BankDetail> bankdetail = bService.getBankDetails();
        return Response.status(Response.Status.OK).entity(bankdetail).build();
    }
    catch(Exception e){
    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
}


@POST
@Path("/updateBankDetails")
@Operation(description = "Updating the bank details")
public Response updateBankDetails(BankDetail bankDetail)
{
    try{
        return bService.editBankDetails(bankDetail);
    }
    catch(Exception e){
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
}

}
}
