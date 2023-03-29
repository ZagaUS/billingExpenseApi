package zaga.biling.invoice.Repo;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import zaga.biling.invoice.Model.BankDetail;

@ApplicationScoped
public class bankDetailRepo implements PanacheMongoRepository<BankDetail> {
    
}
