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
@JsonIgnoreProperties("{id}")
@MongoEntity(collection = "BankDetail",database = "BillingInvoice")

public class ProjectBill extends PanacheMongoEntity{
    private String projectId;
    private String po;
    private String sfdc;
    private String pa;
    private String duration;
    private String totalMd;
    private String bilRate;
    private String md;
    private String invoiceAmount;
}

