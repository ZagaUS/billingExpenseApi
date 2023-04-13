package zaga.biling.invoice.serviceimplimentation;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import zaga.biling.invoice.model.BankDetail;
import zaga.biling.invoice.repo.BankDetailRepo;
import zaga.biling.invoice.service.BankDetailService;

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
