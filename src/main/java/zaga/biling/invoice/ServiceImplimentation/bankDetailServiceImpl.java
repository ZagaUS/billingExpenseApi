package zaga.biling.invoice.ServiceImplimentation;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import zaga.biling.invoice.Model.BankDetail;
import zaga.biling.invoice.Repo.BankDetailRepo;
import zaga.biling.invoice.Service.BankDetailService;

@ApplicationScoped
public class BankDetailServiceImpl implements BankDetailService {

    @Inject
    BankDetailRepo bRepo;


    @Override
    public BankDetail addBankDetail(BankDetail bDetail) {
        BankDetail.persist(bDetail);
        return bDetail;
     }


    @Override
    public List<BankDetail> getBankDetails() {
        List<BankDetail> bankList = bRepo.getAllBankDet();
        return bankList;
    }


    @Override
    public Response editBankDetails(BankDetail bankDetail) {
        bRepo.editBankDetail(bankDetail);
        return Response.status(Response.Status.OK).build();

    }
    
}
