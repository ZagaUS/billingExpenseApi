package zaga.biling.invoice.repo;

import javax.enterprise.context.ApplicationScoped;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import zaga.biling.invoice.model.InvoiceDto;

@ApplicationScoped
public class InvoiceDtoRepository implements PanacheMongoRepository<InvoiceDto> {

    
}
