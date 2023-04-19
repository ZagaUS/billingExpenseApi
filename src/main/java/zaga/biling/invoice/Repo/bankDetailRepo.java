package zaga.biling.invoice.Repo;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.mongodb.panache.PanacheQuery;
import zaga.biling.invoice.Model.BankDetail;

@ApplicationScoped
public class bankDetailRepo implements PanacheMongoRepository<BankDetail> {

    public List<BankDetail> getAllBankDet() {
        List<BankDetail> bankRep = BankDetail.listAll();
        return bankRep;
    }

    public BankDetail findbybankAccount(String bankAccount) {

        return find("bankAccount", bankAccount).firstResult();
    }
}
