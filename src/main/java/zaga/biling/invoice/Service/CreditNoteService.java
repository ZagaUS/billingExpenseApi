package zaga.biling.invoice.Service;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;

import zaga.biling.invoice.Model.CreditNote;
import zaga.biling.invoice.Model.CreditNotePdf;

@ApplicationScoped
public interface CreditNoteService {

    Response generateCreditNote(CreditNote creditNote) throws IOException;

    CreditNote addCreditNote(CreditNote creditNote);

    List<CreditNotePdf> findCreditNotesByProjectId(String projectId);

    CreditNotePdf findByCreditNoteId(String documentId);

    Response deleteCreditNote(String documentId);

}
