package zaga.biling.invoice.Rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

import javax.inject.Inject;

import org.eclipse.microprofile.openapi.annotations.Operation;

import zaga.biling.invoice.Model.BankDetail;
import zaga.biling.invoice.Service.bankDetailService;

@Path("/Zaga/Invoice")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class bankdetailRest {

    @Inject
    bankDetailService bService;

    @POST
    @Path(value = "/createBankDetails")
    @Operation(description = "create the bank details")
    public Response createBankDetails(BankDetail bDetail) {
        try {
            BankDetail bDetailNew = bService.addBankDetail(bDetail);
            System.out.println("BankDetail 1: ");
            return Response.status(Response.Status.OK).entity(bDetailNew).build();
        } catch (Exception e) {
            {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            }
        }

    }

    @GET
    @Path(value = "/getAllBankCredential")
    @Operation(description = "Get all the bankDetails")
    public Response getAllBankDetails() {
        try {
            List<BankDetail> bankdetail = bService.getBankDetails();
            return Response.status(Response.Status.OK).entity(bankdetail).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    // not required for now
    @GET
    @Path(value = "/getAllBankCredential/{bankAccount}")
    @Operation(description = "Get the bankDetails by id ")
    public Response getBankDetailsbyaccount(@PathParam("bankAccount") String bankAccount) {
        try {
            BankDetail bankdetail = bService.getBankDetailsbyBankAccount(bankAccount);
            return Response.status(Response.Status.OK).entity(bankdetail).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    @Path("/updateBankDetails/{bankAccount}")
    @Operation(description = "Updating the bank details")
    public Response updateBankDetails(@PathParam("bankAccount") String bankAccount, BankDetail bankDetail) {
        try {
            BankDetail bankDetail2 = bService.editBankDetails(bankAccount, bankDetail);
            return Response.status(Response.Status.OK).entity(bankDetail2).build();

        } catch (Exception e) {
            {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            }
        }

    }
}
