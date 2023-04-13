package zaga.biling.invoice.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;

import zaga.biling.invoice.model.SequenceCounters;
import zaga.biling.invoice.repo.SequenceRepository;

@Path("/Zaga/Invoice")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Counter {

    @Inject
    SequenceRepository repository;

    @POST
    @Path(value = "/Counter")
    @Operation(description = "create counter sequence")
    public SequenceCounters addSequenceCounters(SequenceCounters sequenceCounters) {

        repository.persist(sequenceCounters);
        return sequenceCounters;

    }

}
