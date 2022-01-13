package project.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import project.demo.model.DummyAccount;


@RepositoryRestResource
public interface IDummyAccountRepo extends CrudRepository<DummyAccount,Integer> {
    // Dummy data for testing
    // TODO: remove when working + read from DB/IRepo

    // For a specific DummyClient get a list of DummyAccounts
    // TODO write native SQL query

}
