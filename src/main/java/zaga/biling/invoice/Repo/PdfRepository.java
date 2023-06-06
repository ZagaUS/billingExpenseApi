package zaga.biling.invoice.Repo;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import zaga.biling.invoice.Model.PdfEntity;

@ApplicationScoped
public class PdfRepository implements PanacheMongoRepository<PdfEntity> {

    

    public PdfEntity findById(String documentId) {
        return find("documentId", documentId).firstResult();
    }
    public void deleteById(String documentId) {
        PdfEntity.delete("documentId", documentId);

}}
