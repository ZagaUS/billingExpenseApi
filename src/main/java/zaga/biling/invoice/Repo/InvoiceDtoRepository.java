package zaga.biling.invoice.Repo;

import javax.enterprise.context.ApplicationScoped;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import zaga.biling.invoice.Model.InvoiceDto;

@ApplicationScoped
public class InvoiceDtoRepository implements PanacheMongoRepository<InvoiceDto> {

    public InvoiceDto findById(String id) {
        return find("invoiceId", id).firstResult();
    }
}
