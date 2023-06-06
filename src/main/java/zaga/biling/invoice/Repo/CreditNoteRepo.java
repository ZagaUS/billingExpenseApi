package zaga.biling.invoice.Repo;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import zaga.biling.invoice.Model.CreditNote;

@ApplicationScoped
public class CreditNoteRepo implements PanacheMongoRepository<CreditNote>{
 
    
    public List<CreditNote> findCreditNotesByProjectId(String projectId) {
        List<CreditNote> creditNotes = CreditNote.list("projectId=?1",projectId);
        return creditNotes;
    }

    public Long deleteCreditNoteById(String creditNoteId) {
        System.out.println("creditNoteRepo" + creditNoteId);
        return CreditNote.delete("creditNoteId", creditNoteId.toString());
    }

    public CreditNote findbyCreditNoteId(String creditNoteId) {

        System.out.println("repo");
        return find("creditNoteId", creditNoteId).firstResult();
    }

}
