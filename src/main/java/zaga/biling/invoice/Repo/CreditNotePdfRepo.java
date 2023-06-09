package zaga.biling.invoice.Repo;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import zaga.biling.invoice.Model.CreditNotePdf;

@ApplicationScoped
public class CreditNotePdfRepo implements PanacheMongoRepository<CreditNotePdf>{

 
    
    public List<CreditNotePdf> findCreditNotesByProjectId(String projectId) {
        List<CreditNotePdf> creditNotes = CreditNotePdf.list("projectId=?1",projectId);
        return creditNotes;
    }

    public Long deleteCreditNotePdfById(String documentId) {
        System.out.println("creditNoteRepo" + documentId);
        return CreditNotePdf.delete("documentId=?1",documentId);
    }

    public CreditNotePdf findbyCreditNoteId(String documentId) {

        System.out.println("repo");
        return find("documentId=?1", documentId).firstResult();
    }

}
    
