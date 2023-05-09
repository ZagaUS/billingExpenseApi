package zaga.biling.invoice.Rest;

import java.time.LocalDate;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;

import zaga.biling.invoice.Model.ProjectDetails;
import zaga.biling.invoice.Model.WeeklyTimesheet;
import zaga.biling.invoice.Repo.ProjectDetailsInvoiceRepo;
import zaga.biling.invoice.Service.ProjectDetailsInvoiceService;
import zaga.biling.invoice.ServiceImplimentation.ResponseWrapper2;

@Path("/Zaga/Invoice")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProjectDetailsInRest {

    @Inject
    ProjectDetailsInvoiceRepo repo;

    @Inject
    ProjectDetailsInvoiceService service;


    @GET
    @Path("/getProjectDetailsInvoice/{projectName},{startDate},{endDate}")
    @Operation(description = "generate the invoice")
    public Response getProjectDetails(@PathParam ("projectName")String projectName,@PathParam ("startDate")LocalDate startDate,@PathParam("endDate")LocalDate endDate){
        ProjectDetails projectDetails = repo.findbyProjectName(projectName) ;         
        WeeklyTimesheet timesheetpdf = service.generateWeeeklyTimesheet(projectName, startDate, endDate);

                 //   ProjectDetails ser = service.getbyprojectName(projectName, endDate, endDate);
                    ResponseWrapper2 responseWrapper = new ResponseWrapper2(projectDetails, timesheetpdf);
                    return Response.status(Response.Status.OK).entity(responseWrapper).build();
    }

    // @GET
    // @Path("/getAllProjectDetails")
    // public Response getAllprojectDetails(){
    //     return Response.ok().build();
    // }




}
