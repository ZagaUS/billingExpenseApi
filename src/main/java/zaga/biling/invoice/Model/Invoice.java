package zaga.biling.invoice.Model;

import java.time.LocalDate;
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
@JsonIgnoreProperties({ "id" })
@MongoEntity(collection = "Invoice", database = "BillingInvoice")
public class Invoice extends PanacheMongoEntity {

    public String invoiceId;
    public LocalDate date;
    public String clientAddress;
    public String projectName;
    public String consultant;
    public String note;
    public String payOrder;
    public String sfdc;
    public String pa;
    public Float totalManDays;
    public Float manHours;
    public Float invoiceAmount;
    public Float totalInvoiceAmount;

    public Currency clientCurrency;

    public String documentType;
    public String projectId;
    public LocalDate startDate;
    public LocalDate endDate;
    public String documentId;

    public String duration;
    public Float rate;

}
