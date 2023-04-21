// package zaga.biling.invoice.REST;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;
// import static org.junit.jupiter.api.Assertions.assertNull;
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.ArgumentMatchers.eq;
// import static org.mockito.Mockito.when;

// import java.io.IOException;
// import java.time.LocalDate;

// import javax.inject.Inject;
// import javax.ws.rs.core.Response;

// import org.bson.types.Binary;
// import org.junit.jupiter.api.Assertions;
// import org.junit.jupiter.api.Test;

// import io.quarkus.test.junit.QuarkusTest;
// import io.restassured.RestAssured;
// import io.restassured.http.ContentType;
// import zaga.biling.invoice.Model.Invoice;
// import zaga.biling.invoice.Model.PdfEntity;
// import zaga.biling.invoice.Repo.PdfRepository;
// import zaga.biling.invoice.Service.invoiceService;
// import zaga.biling.invoice.client.PdfService;

// @QuarkusTest
// public class InvoiceTest {

// @Inject
// PdfService pdfService;

// @Inject
// invoiceService invoiceService;

// @Inject
// PdfRepository pdfRepository;
// // @Test
// // public void CreateInvoiceTest() {

// // Invoice invoice = new Invoice("5", null, "Kovilpatti", "CITI", "ANushiya",
// // "vitrtually done", null, null, null, null, null, null, null);
// // Invoice BD =
// //
// //
// RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON).body(invoice)
// // .when().post("/Zaga/Invoice/createInvoice")
// // .then().statusCode(200).assertThat().extract().as(Invoice.class);
// // Assertions.assertEquals("ANushiya", BD.getConsultant());
// // }

// // @Test
// // public void testGenerateInvoicePdf() throws IOException {

// // // create a test invoice
// // Invoice invoice = new Invoice();
// // invoice.setInvoiceId("INV-001");
// // invoice.setDate(LocalDate.now());
// // invoice.setClientAddress("123 Main St, Anytown USA");
// // invoice.setProjectName("Test Project");
// // invoice.setConsultant("John Doe");
// // invoice.setNote("Test note");
// // invoice.setPayOrder("PO-001");
// // invoice.setSfdc("SFDC-001");
// // invoice.setPa("PA-001");
// // invoice.setTotalManDays(8.0f);
// // invoice.setManDays(8.0f);
// // invoice.setInvoiceAmount(1000.0f);
// // invoice.setTotalInvoiceAmount(1000.0f);

// // // mock the pdf service to return a byte array response
// // byte[] pdfBytes = "test pdf content".getBytes();
// // Response mockResponse = Response.ok(pdfBytes).build();
// // when(pdfService.generateInvoicePdf(invoice)).thenReturn(mockResponse);

// // // call the endpoint

// // RestAssured.given().contentType(ContentType.JSON)
// // .accept(ContentType.JSON)
// // .body(invoice)
// // .when()
// // .post("/Zaga/Invoice/createInvoicee/pdf")
// // .then()
// // .statusCode(200).extract().response();

// // // // verify the response body
// // // PdfEntity pdfDocument = response.as(PdfEntity.class);
// // // assertNotNull(pdfDocument.getId());
// // // assertEquals("", pdfDocument.getProjectId());
// // // assertNull(pdfDocument.getDocumentId());
// // // assertNull(pdfDocument.getProjectName());
// // // // assertArrayEquals(pdfBytes, pdfDocument.getData());
// // // assertNotNull(pdfDocument.getStartDate());
// // // assertNotNull(pdfDocument.getEndDate());

// // // verify the invoice was added to the database
// // Invoice savedInvoice = invoiceService.getInvoicebyId("INV-001");
// // assertNotNull(savedInvoice);
// // assertEquals(invoice.getClientAddress(), savedInvoice.getClientAddress());
// // assertEquals(invoice.getProjectName(), savedInvoice.getProjectName());
// // assertEquals(invoice.getConsultant(), savedInvoice.getConsultant());
// // assertEquals(invoice.getNote(), savedInvoice.getNote());
// // assertEquals(invoice.getPayOrder(), savedInvoice.getPayOrder());
// // assertEquals(invoice.getSfdc(), savedInvoice.getSfdc());
// // assertEquals(invoice.getPa(), savedInvoice.getPa());
// // assertEquals(invoice.getTotalManDays(), savedInvoice.getTotalManDays());
// // assertEquals(invoice.getManDays(), savedInvoice.getManDays());
// // assertEquals(invoice.getInvoiceAmount(), savedInvoice.getInvoiceAmount());
// // assertEquals(invoice.getTotalInvoiceAmount(),
// // savedInvoice.getTotalInvoiceAmount());
// // }

// // @Test
// public void getAllInvoiceDetailsTest() {
// RestAssured.given().contentType(ContentType.JSON).when().get("/Zaga/Invoice/getAllInvoices").then()
// .statusCode(200);
// }

// // @Test
// public void getAllInvoiceDetailsNegativeTest() {
// RestAssured.given().contentType(ContentType.JSON).when().get("/getAllInvoices").then()
// .statusCode(404);
// }

// // @Test
// // public void editInvoiceDetailsTest() {

// // Invoice invoice = new Invoice("5", null, "Kovilpatti", "CITI", "ANushiya",
// // "vitrtually done", null, null, null, null, null, null, null);
// // RestAssured.given().contentType(ContentType.JSON).body(invoice).when()
// // .post("/Zaga/Invoice/updateInvoice").then()
// // .statusCode(500);
// // }

// // @Test
// public void testDeleteInvoice() {
// RestAssured.given()
// .when().delete("/Zaga/Invoice/deleteInvoice/{invoiceId}", "5")
// .then()
// .statusCode(200);
// }
// }
