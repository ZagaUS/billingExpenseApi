package zaga.biling.invoice.model;

import java.sql.Date;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "id" })
public class InvoiceDto {

    private String invoiceId;

    private LocalDate date;
    private String clientAddress;
    public String payOrder;
    public String sfdc;
    public String pa;
    public Float totalManDays;
    public Float manDays;
    public Float invoiceAmount;
    public Float tolaInvoiceAmount;

    // manDays; as totalManHours;

    // Below field need in updated in pdf service
    // private String projectName;
    // private String consultant;
    // public LocalDate startDate;
    // public LocalDate endDate;
}
