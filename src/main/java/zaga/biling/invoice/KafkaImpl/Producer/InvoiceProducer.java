//package zaga.biling.invoice.kafkaImpl.producer;

// import javax.inject.Inject;
// import javax.ws.rs.Consumes;
// import javax.ws.rs.POST;
// import javax.ws.rs.Path;
// import javax.ws.rs.Produces;
// import javax.ws.rs.core.MediaType;

// import org.eclipse.microprofile.reactive.messaging.Channel;
// import org.eclipse.microprofile.reactive.messaging.Emitter;

// import zaga.biling.invoice.Model.Invoice;

// @Path("/ProduceInvoKafka")
// public class InvoiceProducer {

// @Inject
// @Channel("Invoice-out")
// Emitter<Invoice> emitter;

// @POST
// @Produces(MediaType.APPLICATION_JSON)
// @Consumes(MediaType.APPLICATION_JSON)
// public Invoice invoiceProducer(Invoice invo){

// emitter.send(invo);

// // Message<ProjectDetails> op = emitter.;

// return invo ;
// }
// }
