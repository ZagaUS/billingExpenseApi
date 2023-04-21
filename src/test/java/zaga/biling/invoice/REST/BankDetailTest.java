package zaga.biling.invoice.REST;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
//import io.restassured.module.jsv.JsonSchemaValidator;

import javax.inject.Inject;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import zaga.biling.invoice.Model.BankDetail;
import zaga.biling.invoice.Service.bankDetailService;

@QuarkusTest
public class BankDetailTest {

        @Inject
        bankDetailService bService;

        @Test
        public void CreateBankDetailTest() {

                BankDetail bankDetail = new BankDetail("1234567", "qew6", "656", "IOB",
                                "Kovilpatti", "12345", "32", "234");
                BankDetail BD = RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON)
                                .body(bankDetail)
                                .when().post("/Zaga/Invoice/createBankDetails")
                                .then().statusCode(200).assertThat().extract().as(BankDetail.class);
                Assertions.assertEquals("IOB", BD.getBankName());

        }

        @Test
        public void getAllBankDetailsTest() {
                RestAssured.given().contentType(ContentType.JSON).when().get("/Zaga/Invoice/getAllBankCredential")
                                .then()
                                .statusCode(200);
        }

        @Test
        public void getAllBankDetailsNegativeTest() {
                RestAssured.given().contentType(ContentType.JSON).when().get("/getAllBankCredential").then()
                                .statusCode(404);
        }

        // test cases

        @Test
        public void testCreateBankDetailsSuccess() {
                BankDetail bDetail = new BankDetail("12345", "IOB", "Kovilpatti", "656",
                                "1234567", "32", "qew6", "234");
                given()
                                .contentType(ContentType.JSON).accept(ContentType.JSON)
                                .body(bDetail)
                                .when().post("/Zaga/Invoice/createBankDetails")
                                .then()
                                .statusCode(200)
                                .body("gst", equalTo(bDetail.getGst()))
                                .body("pan", equalTo(bDetail.getPan()))
                                .body("cin", equalTo(bDetail.getCin()))
                                .body("bankName", equalTo(bDetail.getBankName()))
                                .body("branchName", equalTo(bDetail.getBranchName()))
                                .body("bankAccount", equalTo(bDetail.getBankAccount()))
                                .body("ifsc", equalTo(bDetail.getIfsc()))
                                .body("swiftCode", equalTo(bDetail.getSwiftCode()));
        }

        @Test
        public void testCreateBankDetailsBadRequest() {
                BankDetail bDetail = new BankDetail("", "", "", "", "", "", "", "");
                given()
                                .contentType(ContentType.JSON)
                                .body(bDetail)
                                .when().post("/Zaga/Invoice/createBankDetails")
                                .then()
                                .statusCode(200);
        }

        @Test
        public void testGetAllBankDetails() {
                BankDetail bankDetail1 = new BankDetail("1234567", "qew6", "656", "IOB",
                                "Kovilpatti", "12345", "32", "234");
                BankDetail bankDetail2 = new BankDetail("1234567", "qew6", "656", "IOB",
                                "Kovilpatti", "12345", "33", "234");
                bService.addBankDetail(bankDetail1);
                bService.addBankDetail(bankDetail2);

                List<BankDetail> response = RestAssured.given()
                                .when()
                                .get("/Zaga/Invoice/getAllBankCredential")
                                .then()
                                .statusCode(200)
                                .extract()
                                .body()
                                .jsonPath()
                                .getList(".", BankDetail.class);

                assertEquals("1234567", response.get(0).getGst());
                assertEquals("qew6", response.get(0).getPan());
                assertEquals("656", response.get(0).getCin());
                assertEquals("IOB", response.get(0).getBankName());
                assertEquals("Kovilpatti", response.get(0).getBranchName());
                assertEquals("1235454545", response.get(0).getBankAccount());
                assertEquals("32", response.get(0).getIfsc());
                assertEquals("234", response.get(0).getSwiftCode());
                assertEquals("1234567", response.get(1).getGst());
                assertEquals("qew6", response.get(1).getPan());
                assertEquals("656", response.get(1).getCin());
                assertEquals("IOB", response.get(1).getBankName());
                assertEquals("Kovilpatti", response.get(1).getBranchName());
                assertEquals("12345", response.get(1).getBankAccount());
                assertEquals("32", response.get(1).getIfsc());
                assertEquals("234", response.get(1).getSwiftCode());
        }

        @Test
        public void testUpdateBankDetails() {
                BankDetail bankDetail = new BankDetail("12345", "IOB", "Kovilpatti", "656",
                                "1234567", "32", "qew6", "234");
                bService.addBankDetail(bankDetail);

                bankDetail.setBankName("NewBankName");

                given()
                                .contentType(ContentType.JSON).accept(ContentType.JSON)
                                .body(bankDetail)
                                .when().put("/Zaga/Invoice/updateBankDetails/32")
                                .then()
                                .statusCode(200).assertThat().extract().as(BankDetail.class);

                BankDetail updatedBankDetail = bService.getBankDetailsbyBankAccount(bankDetail.getBankAccount());
                assertEquals("NewBankName", updatedBankDetail.getBankName());
        }
}
