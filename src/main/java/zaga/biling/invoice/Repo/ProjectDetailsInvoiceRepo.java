package zaga.biling.invoice.Repo;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import zaga.biling.invoice.Model.ProjectDetails;

@ApplicationScoped
public class ProjectDetailsInvoiceRepo implements PanacheMongoRepository<ProjectDetails> {

  public ProjectDetails findbyProjectName(String projectName) {
    return ProjectDetails.find("projectName=?1", projectName).firstResult();

  }

}
