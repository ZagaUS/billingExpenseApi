package zaga.biling.invoice.repo;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.mongodb.panache.PanacheQuery;
import zaga.biling.invoice.model.BankDetail;

@ApplicationScoped
public class BankDetailRepo implements PanacheMongoRepository<BankDetail> {

    public List<BankDetail> getAllBankDet() {
        List<BankDetail> bankRep = BankDetail.listAll();
        return bankRep;
    }

    public BankDetail editBankDetail(BankDetail bankDetail) {
        String bankAccount = bankDetail.getBankAccount();
        PanacheQuery<BankDetail> check = BankDetail.find("bankAccount = ?1", bankAccount);
        BankDetail b = check.firstResult();

        b.setBankAccount(bankDetail.getBankAccount());
        b.setBankName(bankDetail.getBankName());
        b.setBranchName(bankDetail.getBranchName());
        b.setCin(bankDetail.getCin());
        b.setGst(bankDetail.getGst());
        b.setIfsc(bankDetail.getIfsc());
        b.setPan(bankDetail.getPan());
        b.setSwiftCode(bankDetail.getSwiftCode());

        BankDetail.update(b);
        return b;
    }

}
