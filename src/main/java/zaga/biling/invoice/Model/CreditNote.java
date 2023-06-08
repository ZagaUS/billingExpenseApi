package zaga.biling.invoice.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor
@NoArgsConstructor
@MongoEntity(collection = "creditNote", database = "BillingInvoice")
@JsonIgnoreProperties({"id"})
public class CreditNote extends PanacheMongoEntity {


    
    public String creditNoteId;
    public String invoiceId;
    public String clientAddress;
    public String ref;
    public String referenceInvoice;
    public String po;
    public String sfdc;
    public String pa;
    public CurrencyType currencyType;
    public Float paidAmount;
    public Float actualAmount;
    public Float creditAmount;
    public String projectId;

}
