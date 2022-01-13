package project.demo.repositories;

import project.demo.model.DummyClient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface IDummyClientRepo extends CrudRepository<DummyClient,Integer> {
    // Dummy data for testing
    // TODO: remove when working + read from DB/IRepo
}
