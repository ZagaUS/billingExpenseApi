package zaga.biling.invoice.REST;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import zaga.biling.invoice.Model.BankDetail;

@QuarkusTest
public class BankDetailTest {

    @Test
    public void CreateBankDetailTest() {

        BankDetail bankDetail = new BankDetail("1234567","qew6", "656","IOB","Kovilpatti","12345","32","234");
        BankDetail BD = RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON).body(bankDetail)
        .when().post("/Zaga/Invoice/createBankDetails")
        .then().statusCode(200).assertThat().extract().as(BankDetail.class);
        Assertions.assertEquals("IOB",BD.getBankName());

    }

    
    @Test
    public void getAllBankDetailsTest()
    {
         RestAssured.given().contentType(ContentType.JSON).when().get("/Zaga/Invoice/getAllBankCredential").then()
                .statusCode(200);
    }  
    
    
    @Test
    public void getAllBankDetailsNegativeTest()
    {
        RestAssured.given().contentType(ContentType.JSON).when().get("/getAllBankCredential").then()
                .statusCode(404);
    }

    @Test
    public void editBankDetailsTest() {

        BankDetail bankDetail = new BankDetail();
        RestAssured.given().contentType(ContentType.JSON).body(bankDetail).when()
                .post("/Zaga/Invoice/updateBankDetails").then()
                .statusCode(405);
    }


}
