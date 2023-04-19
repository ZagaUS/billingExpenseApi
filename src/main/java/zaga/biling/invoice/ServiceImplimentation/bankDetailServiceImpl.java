package zaga.biling.invoice.ServiceImplimentation;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import zaga.biling.invoice.Model.BankDetail;
import zaga.biling.invoice.Repo.bankDetailRepo;
import zaga.biling.invoice.Service.bankDetailService;

@ApplicationScoped
public class bankDetailServiceImpl implements bankDetailService {

    @Inject
    bankDetailRepo bRepo;

    @Override
    public BankDetail addBankDetail(BankDetail bDetail) {
        bRepo.persist(bDetail);
        return bDetail;
    }

    @Override
    public List<BankDetail> getBankDetails() {
        List<BankDetail> bankList = bRepo.getAllBankDet();
        return bankList;
    }

    @Override
    public BankDetail editBankDetails(String bankAccount, BankDetail bankDetail) {

        BankDetail b = bRepo.findbybankAccount(bankAccount);

        b.setBankAccount(bankDetail.getBankAccount());
        b.setBankName(bankDetail.getBankName());
        b.setBranchName(bankDetail.getBranchName());
        b.setCin(bankDetail.getCin());
        b.setGst(bankDetail.getGst());
        b.setIfsc(bankDetail.getIfsc());
        b.setPan(bankDetail.getPan());
        b.setSwiftCode(bankDetail.getSwiftCode());
        bRepo.update(b);
        return b;

    }

    @Override
    public BankDetail getBankDetailsbyBankAccount(String bankAccount) {
        return bRepo.findbybankAccount(bankAccount);
    }

}
