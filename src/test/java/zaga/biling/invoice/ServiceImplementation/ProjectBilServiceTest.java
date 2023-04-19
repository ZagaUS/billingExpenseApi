package zaga.biling.invoice.ServiceImplementation;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import zaga.biling.invoice.Model.ProjectBill;

@QuarkusTest
public class ProjectBilServiceTest {

    @Test
    public void addProjectBillTest() {

        ProjectBill bill = new ProjectBill("100", "7", "200", "2", "3424", "345671", "1", "65", "546");
        // List<ProjectBill> pro = new ArrayList<ProjectBill>();
        // pro.add(0,bill);
        // ProjectBill proj = new ProjectBill();
        String a = bill.getBilRate();
        String b = bill.getMd();
        String add = a + "," + b;
        bill.setInvoiceAmount(add);

    }

}
