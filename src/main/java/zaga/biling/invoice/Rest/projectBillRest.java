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

import zaga.biling.invoice.Model.ProjectBill;
import zaga.biling.invoice.Service.ProjectBillService;

@Path("/Zaga/Invoice")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProjectBillRest {

 @Inject
 ProjectBillService proService;

@GET
@Path("/getAllProjectBill")
@Operation(description = "Get all Project Bill")
public Response getProjectBill(){
    try{
       List<ProjectBill> proBill = proService.getAllProjectBill();
       return Response.status(Response.Status.OK).entity(proBill).build();
    } catch(Exception e){
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
}

// @POST
// @Path("/totalInvoiceAmount")
// @Operation(description = "Calculate the total Invoice amount")
// public Response calculateInvoiceAmount(ProjectBill proBill){
// try{
//     return proService.CalculateInvoiceAmt(proBill);
// }
// catch(Exception e){
//     return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
// }

// }

@POST
@Path("/createProjectBill")
@Operation(description = "Creating a new ProjectBill")
public Response createInvoice(ProjectBill proBill){
    // System.out.println("Invoice"+invoice);
    try {
        // System.out.println("Invoice inside try"+invoice);
        ProjectBill projectBillNew = proService.addProjectBill(proBill);
        return Response.status(Response.Status.OK).entity(projectBillNew).build();
    } catch (Exception e) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
}


@POST
@Path("/updateProjectBill")
@Operation(description = "Updating the ProjectBill")
public Response updateInvoice(ProjectBill proBill){
    try {

        return proService.editProjectBill(proBill);
    } catch (Exception e) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();

    }

}
@DELETE
@Path("/deleteProjectBill")
@Operation(description = "Deleting a project bill by its ID")
public Response deleteInvoice(String projectId){
    try{
        System.out.println("projectRest"+projectId);
        return proService.deleteProjectBill(projectId);
    }
    catch(Exception e) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
}

}   
}
