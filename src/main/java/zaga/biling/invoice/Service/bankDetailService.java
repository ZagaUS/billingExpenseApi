package zaga.biling.invoice.Service;

import java.util.List;

import javax.ws.rs.core.Response;

import zaga.biling.invoice.Model.BankDetail;

public interface bankDetailService {

    BankDetail addBankDetail(BankDetail bDetail);

    List<BankDetail> getBankDetails();

    BankDetail getBankDetailsbyBankAccount(String bankAccount);

    BankDetail editBankDetails(String id, BankDetail bankDetail);
}
