package zaga.biling.invoice.Model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"id"})
@MongoEntity(collection = "Invoice",database = "BillingInvoice")
public class Invoice extends PanacheMongoEntity {
    
    private String invoiceId;
    private Date date;
    private String clientAddress;
    private String projectName;
    private String consultant;
    private String note;
}
