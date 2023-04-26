// package zaga.biling.invoice.REST;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;
// import static org.junit.jupiter.api.Assertions.assertNull;
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.ArgumentMatchers.eq;
// import static org.mockito.Mockito.when;

// import java.io.IOException;
// import java.time.LocalDate;
// import java.util.List;

// import javax.inject.Inject;
// import javax.ws.rs.core.Response;

// import org.bson.types.Binary;
// import org.junit.jupiter.api.Assertions;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// import io.quarkus.test.junit.QuarkusTest;
// import io.restassured.RestAssured;
// import io.restassured.common.mapper.TypeRef;
// import io.restassured.http.ContentType;
// import zaga.biling.invoice.Model.Invoice;
// import zaga.biling.invoice.Model.PdfEntity;
// import zaga.biling.invoice.Repo.PdfRepository;
// import zaga.biling.invoice.Service.invoiceService;
// import zaga.biling.invoice.client.PdfService;

// @QuarkusTest
// public class InvoiceTest {

// @Inject
// invoiceService invoiceService;

// @Inject
// PdfRepository pdfRepository;

// @Test
// public void testGetAllInvoices() {
// Invoice invoice = new Invoice("JPMorgan Chase_19", LocalDate.of(2023, 4, 7),
// "US", "JPMorgan Chase", "Raghul",
// "service done virtually", "22941671987802", "394220", "52717662029185", 7,
// 56, 3920, 3920, "5",
// LocalDate.of(2022, 3, 10), LocalDate.of(2022, 3, 10));
// invoiceService.addInvoice(invoice);
// List<Invoice> response = io.restassured.RestAssured.given()
// .contentType(ContentType.JSON)
// .when().get("/Zaga/Invoice/getAllInvoices")
// .then()
// .statusCode(200).extract().body()
// .jsonPath()
// .getList(".", Invoice.class);

// // assertEquals(1, invoice.size());
// // Invoice invoice = invoice.get(0);
// // assertEquals("JPMorgan Chase_19", response.get(0).getInvoiceId());
// // assertEquals(LocalDate.of(2023, 4, 7), response.get(0).getDate());
// // assertEquals("US", response.get(0).getClientAddress());
// // assertEquals("JPMorgan Chase", response.get(0).getProjectName());
// // assertEquals("Raghul", response.get(0).getConsultant());
// // assertEquals("service done virtually", response.get(0).getNote());
// // assertEquals("22941671987802", response.get(0).getPayOrder());
// // assertEquals("394220", response.get(0).getSfdc());
// // assertEquals("52717662029185", response.get(0).getPa());
// // assertEquals(7, response.get(0).getTotalManDays());
// // assertEquals(null, response.get(0).getManHours());
// // assertEquals(3920, response.get(0).getInvoiceAmount());
// // assertEquals(3920, response.get(0).getTotalInvoiceAmount());
// // assertEquals("5", response.get(0).getProjectId());
// // assertEquals(LocalDate.of(2022, 3, 10), response.get(0).getStartDate());
// // assertEquals(LocalDate.of(2022, 3, 10), response.get(0).getEndDate());

// assertEquals("JPMorgan Chase_19", invoice.invoiceId);

// assertEquals(LocalDate.of(2023, 4, 7), invoice.date);
// assertEquals("US", invoice.clientAddress);
// assertEquals("JPMorgan Chase", invoice.projectName);
// assertEquals("Raghul", invoice.consultant);
// assertEquals("service done virtually", invoice.note);
// assertEquals("22941671987802", invoice.payOrder);
// assertEquals("394220", invoice.sfdc);
// assertEquals("52717662029185", invoice.pa);
// assertEquals(7, invoice.totalManDays);
// assertEquals(null, invoice.manHours);
// assertEquals(3920, invoice.invoiceAmount);
// assertEquals(3920, invoice.totalInvoiceAmount);
// assertEquals("5", invoice.projectId);
// assertEquals(LocalDate.of(2022, 3, 10), invoice.startDate);
// assertEquals(LocalDate.of(2022, 3, 10), invoice.endDate);
// }
// }
