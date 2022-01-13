package project.demo.model;

import lombok.Data;
import project.demo.repositories.RepoManager;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.*;

@Data
//@Entity
//@NoArgsConstructor
public abstract class AbstractClient {
    //region ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Username is unique but id field is used in DB as PK
    private Login login;
    private ClientDetails clientDetails;
    private Set<Account> accounts;
    private Set<Account> authorizedAccounts;
    //endregion

    //region CONSTRUCTOR

    public AbstractClient(Long id, Login login, ClientDetails clientDetails) throws IllegalArgumentException {
        // Check if username exists, if so, throw IllegalArgumentException
        if (checkUserName(login.getUsername())) {
            throw new IllegalArgumentException("Deze gebruikersnaam bestaat al, kies een andere.");
        } else {
            // If username is unique, create AbstractClient
            this.id = id;
            this.login = login;
            this.accounts = new HashSet<>();
            this.authorizedAccounts = new HashSet<>();
            this.clientDetails = clientDetails;
        }
    }


    //endregion

    //region METHODS
    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public void addAuthorizedAccount(Account account) {
        this.authorizedAccounts.add(account);
    }

    public boolean removeAccount(Account account) {
        return this.accounts.remove(account);
    }

    public boolean removeAuthorizedAccount(Account account) {
        return this.authorizedAccounts.remove(account);
    }
    //endregion

    //region Helper Methods (private)
    private boolean checkUserName(String username) {
        return RepoManager.getRepoManager().containsAbstractClient(username);
    }
    //endregion

    //region GETTERS & SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public ClientDetails getClientDetails() {
        return clientDetails;
    }

    public void setClientDetails(ClientDetails clientDetails) {
        this.clientDetails = clientDetails;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public Set<Account> getAuthorizedAccounts() {
        return authorizedAccounts;
    }

    public void setAuthorizedAccounts(Set<Account> authorizedAccounts) {
        this.authorizedAccounts = authorizedAccounts;
    }

    //endregion

    //region TOSTRING, HASH, EQUALS, COMPARE

    @Override
    public String toString() {
        return "AbstractClient{" +
                "id=" + id +
                ", login=" + login +
                ", clientDetails=" + clientDetails +
                ", accounts=" + accounts +
                ", authorizedAccounts=" + authorizedAccounts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractClient that = (AbstractClient) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    //endregion
}
