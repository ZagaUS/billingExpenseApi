package zaga.biling.invoice.Repo;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import zaga.biling.invoice.Model.PdfEntity;

@ApplicationScoped
public class PdfRepository implements PanacheMongoRepository<PdfEntity> {

    public PdfEntity findById(String documentId) {
        return find("documentId", documentId).firstResult();
    }

}
