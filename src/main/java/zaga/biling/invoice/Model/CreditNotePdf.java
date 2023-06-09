package zaga.biling.invoice.Model;

import java.time.LocalDate;

import org.bson.types.Binary;
import org.bson.types.ObjectId;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntityBase;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "id" })
@MongoEntity(collection = "creditnotePdfs", database = "BillingInvoice")

public class CreditNotePdf extends PanacheMongoEntity{
    
    public ObjectId id;
    public String projectId;
    public String documentId;
    public String projectName;
    public Binary data;
    public String invoiceId;

    public String documentType;

}
