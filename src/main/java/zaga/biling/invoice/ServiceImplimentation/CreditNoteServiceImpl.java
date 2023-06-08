package zaga.biling.invoice.ServiceImplimentation;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.bson.types.Binary;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import zaga.biling.invoice.Model.CreditNote;
import zaga.biling.invoice.Model.PdfEntity;
import zaga.biling.invoice.Repo.CreditNoteRepo;
import zaga.biling.invoice.Repo.PdfRepository;
import zaga.biling.invoice.Repo.SequenceRepository;
import zaga.biling.invoice.Service.CreditNoteService;
import zaga.biling.invoice.client.PdfService;

@ApplicationScoped
public class CreditNoteServiceImpl implements CreditNoteService{

    @Inject
    CreditNoteRepo repo;

    @RestClient   
    @Inject
    PdfService service;

    @Inject
    PdfRepository pdfRepo;

    @Inject
    SequenceRepository seqRepo;

    @Override
    public CreditNote addCreditNote(CreditNote creditNote) {
        repo.persist(creditNote);
        return creditNote;
    }
        
    @Override
    public Response generateCreditNote(CreditNote creditNote) throws IOException  {
        PdfEntity pdfEntity = new PdfEntity();
        String seqNo = seqRepo.getSequenceCounter("creditNote");
        System.out.println(creditNote);
        creditNote.setCreditNoteId(seqNo);
        pdfEntity.setProjectId(creditNote.getProjectId());
        // pdfEntity.setProjectName(creditNote.getProjectName());
        pdfEntity.setDocumentId(creditNote.getCreditNoteId());
        System.out.println(creditNote);
        Response response = service.generateCreditNotePdf(creditNote);
        byte[] pdfBytes = response.readEntity(byte[].class);
        InputStream inputStream = new ByteArrayInputStream(pdfBytes);
        pdfEntity.setData(new Binary(inputStream.readAllBytes()));
        System.out.println(creditNote);
        // Invoice
        // creditNote.setCreditNoteId()
        addCreditNote(creditNote);
        System.out.println(pdfEntity);
        pdfRepo.persist(pdfEntity);
        return Response.ok(creditNote).build();
    }

    @Override
    public List<CreditNote> findCreditNotesByProjectId(String projectId) {
        List<CreditNote> creditNotes = repo.findCreditNotesByProjectId(projectId);
        return creditNotes;       
    }

    @Override
    public CreditNote findByCreditNoteId(String creditNoteId) {
        CreditNote cr = repo.findbyCreditNoteId(creditNoteId);
        return cr;
    }

    @Override
    public Response deleteCreditNote(String creditNoteId) {
        repo.deleteCreditNoteById(creditNoteId);
        return Response.ok().build();
    }

}
