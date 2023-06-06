package zaga.biling.invoice.Service;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;

import zaga.biling.invoice.Model.CreditNote;

@ApplicationScoped
public interface CreditNoteService {

    Response generateCreditNote(CreditNote creditNote) throws IOException;

    CreditNote addCreditNote(CreditNote creditNote);

    List<CreditNote> findCreditNotesByProjectId(String projectId);

    CreditNote findByCreditNoteId(String creditNoteId);

    Response deleteCreditNote(String creditNoteId);

}
