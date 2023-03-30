package zaga.biling.invoice.REST;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import zaga.biling.invoice.Model.Invoice;

@QuarkusTest
public class InvoiceTest {
    @Test
    public void CreateInvoiceTest() {

        Invoice invoice = new Invoice("5",null,"Kovilpatti","CITI","ANushiya","vitrtually done");
        Invoice BD = RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON).body(invoice)
        .when().post("/Zaga/Invoice/createInvoice")
        .then().statusCode(200).assertThat().extract().as(Invoice.class);
        Assertions.assertEquals("ANushiya",BD.getConsultant());
    }

    
    @Test
    public void getAllInvoiceDetailsTest()
    { 
        RestAssured.given().contentType(ContentType.JSON).when().get("/Zaga/Invoice/getAllInvoices").then()
                .statusCode(200);
    }
        
    @Test
    public void getAllInvoiceDetailsNegativeTest()
    {
        RestAssured.given().contentType(ContentType.JSON).when().get("/getAllInvoices").then()
                .statusCode(404);
    }
    
    
    @Test
    public void editInvoiceDetailsTest() {

        Invoice invoice = new Invoice("5",null,"Kovilpatti","CITI","ANushiya","vitrtually done");
        RestAssured.given().contentType(ContentType.JSON).body(invoice).when()
                .post("/Zaga/Invoice/updateInvoice").then()
                .statusCode(200);
    }

    @Test
    public void invoiceDeleteTest() {

        Invoice invoice = new Invoice("5",null,"Kovilpatti","CITI","ANushiya","vitrtually done");

        RestAssured.given().contentType(ContentType.JSON).body(invoice)
                .when()
                .delete("/Zaga/Invoice/deleteInvoice").then()
                .statusCode(200);
    }
}
