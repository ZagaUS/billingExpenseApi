package zaga.biling.invoice.ServiceImplimentation;

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
    public BankDetail getBankDetail(BankDetail bDetail) {
        BankDetail.persist(bDetail);
        return bDetail;
    }
    
}
