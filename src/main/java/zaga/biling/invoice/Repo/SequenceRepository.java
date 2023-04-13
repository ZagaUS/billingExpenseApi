package zaga.biling.invoice.repo;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.mongodb.panache.PanacheQuery;
import zaga.biling.invoice.model.SequenceCounters;

@ApplicationScoped
public class SequenceRepository implements PanacheMongoRepository<SequenceCounters> {
  public String getSequenceCounter(String seqname) {

    PanacheQuery<SequenceCounters> count = SequenceCounters.find("seqName = ?1", seqname);
    SequenceCounters scounter = count.firstResult();
    System.out.println(scounter);
    String seqnumber = Integer.toString(scounter.getSeqNumber());
    scounter.setSeqNumber(scounter.getSeqNumber() + 1);
    SequenceCounters.update(scounter);
    return seqnumber;
  }

}
