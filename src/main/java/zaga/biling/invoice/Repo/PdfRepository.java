package zaga.biling.invoice.repo;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.mongodb.panache.PanacheQuery;
import zaga.biling.invoice.model.PdfEntity;

@ApplicationScoped
public class PdfRepository implements PanacheMongoRepository<PdfEntity> {

}
