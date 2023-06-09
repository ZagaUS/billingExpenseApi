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
@JsonIgnoreProperties({ "id" })
@MongoEntity(collection = "BankDetail", database = "BillingInvoice")
public class BankDetail extends PanacheMongoEntity {
    // @NotEmpty
    private String gst;
    private String pan;
    private String cin;
    private String bankName;
    private String branchName;
    private String bankAccount;
    private String ifsc;
    private String swiftCode;

}
