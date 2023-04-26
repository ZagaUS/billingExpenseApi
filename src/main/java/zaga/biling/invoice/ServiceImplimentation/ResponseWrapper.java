package zaga.biling.invoice.ServiceImplimentation;

import zaga.biling.invoice.Model.Invoice;
import zaga.biling.invoice.Model.PdfEntity;

public class ResponseWrapper {
    private PdfEntity pdfDocument;
    private Invoice invoice;

    public ResponseWrapper(PdfEntity pdfDocument, Invoice invoice) {
        this.pdfDocument = pdfDocument;
        this.invoice = invoice;
    }

    public PdfEntity getPdfDocument() {
        return pdfDocument;
    }

    public Invoice getInvoice() {
        return invoice;
    }
}
