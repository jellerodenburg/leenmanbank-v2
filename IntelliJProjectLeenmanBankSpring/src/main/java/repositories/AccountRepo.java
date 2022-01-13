package repositories;

import project.demo.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@RepositoryRestResource
public interface AccountRepo extends CrudRepository<Account, Long> {

    // MAKE DATA
    List<String> accountNumber = new ArrayList<>();
    // create Account data per accountNumber
    // One account DBdata :
    // (String accountNumber, int clientID, Double balance,int authorizedPersonId, int pincode)





    //RETRIEVE DATA

    // find/get all account info by account number -> for transaction
    // retrieve credit account and debit account
    Account findAccountByAccountNumber(@Param("accountNumber") int accountNumber);

    // find/get all account by user -> for transaction
    //TODO find bankAccount by user
    @Query ("")
    List<Account> findAccountByUserId(int userId);

    //find/get all account by user -> for transaction
    //TODO get account by IBAN(NL...)


    //find/get balance by user -> for transaction
    //TODO get balance from Account by IBAN















}
