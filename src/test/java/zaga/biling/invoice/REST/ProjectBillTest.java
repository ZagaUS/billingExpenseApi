package zaga.biling.invoice.REST;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import zaga.biling.invoice.Model.ProjectBill;

@QuarkusTest
public class ProjectBillTest {

    // @Test
    public void CreateProjectBillTest() {
        // ProjectBill projectBill = new ProjectBill("", "", "",);

        ProjectBill projectBill = new ProjectBill("100", "7", "200", "2", "3424", "345671", "1", "65", "546");
        ProjectBill PB = RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON).body(projectBill)
                .when().post("/Zaga/Invoice/createProjectBill")
                .then().statusCode(500).assertThat().extract().as(ProjectBill.class);
        Assertions.assertEquals("345671", PB.getTotalMd());

    }

    @Test
    public void getAllInvoiceDetailsTest() {
        RestAssured.given().contentType(ContentType.JSON).when().get("/Zaga/Invoice/getAllProjectBill").then()
                .statusCode(200);
    }

    @Test
    public void getAllProjectBillDetailsNegativeTest() {
        RestAssured.given().contentType(ContentType.JSON).when().get("/getAllProjectBill").then()
                .statusCode(404);
    }

    @Test
    public void editProjectDetailsTest() {

        ProjectBill projectBill = new ProjectBill("100", "7", "200", "2", "3424", "345671", "1", "65", "546");
        RestAssured.given().contentType(ContentType.JSON).body(projectBill).when()
                .post("/Zaga/Invoice/updateProjectBill").then()
                .statusCode(500);
    }

    @Test
    public void invoiceDeleteTest() {

        ProjectBill projectBill = new ProjectBill("100", "7", "200", "2", "3424", "345671", "1", "65", "546");

        RestAssured.given().contentType(ContentType.JSON).body(projectBill)
                .when()
                .delete("/Zaga/Invoice/deleteProjectBill").then()
                .statusCode(200);
    }

}
