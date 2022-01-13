package repositories;

import project.demo.model.AbstractClient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AbstractClientRepo extends CrudRepository<AbstractClient,Long> {
    //region Additional Methods
    // Returns true if username is already in use
    boolean findAbstractClientByUsername(@Param("Gebruikersnaam") String username);

    // Returns the user of the specified username
    AbstractClient getAbstractClientByUsername(@Param("Gebruikersnaam") String username);


    // TODO: change name of string (bla) get accountNumber from client
    String accountNumberFromClient(@Param("") String bla);

    //endregion
}
