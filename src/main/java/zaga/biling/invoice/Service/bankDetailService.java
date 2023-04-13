package zaga.biling.invoice.service;

import java.util.List;

import javax.ws.rs.core.Response;

import zaga.biling.invoice.model.BankDetail;

public interface BankDetailService {

    BankDetail addBankDetail(BankDetail bDetail);

    List<BankDetail> getBankDetails();

    Response editBankDetails(BankDetail bankDetail);
}
