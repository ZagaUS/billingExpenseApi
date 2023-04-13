//package zaga.biling.invoice.kafkaImpl.consumer;

// import java.util.ArrayList;
// import java.util.List;

// import javax.ws.rs.GET;
// import javax.ws.rs.Path;

// import org.eclipse.microprofile.reactive.messaging.Incoming;

// import zaga.biling.invoice.Model.Invoice;

// @Path("/ConsumeInvoKafka")
// public class InvoiceConsumer {

// List<Invoice> invoice = new ArrayList<>();
// @GET
// public List<Invoice> consumer(){
// return invoice;
// }

// @Incoming("Invoice-in")
// public void invoiceList(Invoice in){
// invoice.add(in);
// }

// }
