package zaga.biling.invoice.Service;

import java.util.List;

import javax.ws.rs.core.Response;

import zaga.biling.invoice.Model.BankDetail;

public interface BankDetailService {
    
    BankDetail addBankDetail(BankDetail bDetail);

    List<BankDetail> getBankDetails();

    Response editBankDetails(BankDetail bankDetail);
}
