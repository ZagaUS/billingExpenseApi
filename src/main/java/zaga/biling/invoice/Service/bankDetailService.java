package zaga.biling.invoice.Service;

import javax.ws.rs.core.Response;

import zaga.biling.invoice.Model.BankDetail;

public interface bankDetailService {
    
    BankDetail getBankDetail(BankDetail bDetail);
}
