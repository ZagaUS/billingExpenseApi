package zaga.biling.invoice.Rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import zaga.biling.invoice.Model.SequenceCounters;
import zaga.biling.invoice.Repo.SequenceRepository;


@Tag(name = "Sequence Counter", description = "Sequence Generation counter")
@Path("/counters")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SequenceRest {

    @Inject
    SequenceRepository repo;

    @POST
    public Response createCounter(SequenceCounters counter) {
        repo.persist(counter);
        return Response.ok(counter).build();
    }
    
}
