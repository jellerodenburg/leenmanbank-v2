package project.demo.repositories;

import project.demo.model.DummyAccount;

import java.util.ArrayList;
import java.util.List;

public class DummyAccountRepo2 {
    // Dummy data for testing
    // TODO: remove when working + read from DB/IRepo

    private List<DummyAccount> accounts;

    public DummyAccountRepo2() {
        this.accounts = new ArrayList<>();

        this.accounts.add(new DummyAccount(RepoManager.getRepoManager().getDummyClientRepo().getClients().get(0),12.47));
        this.accounts.add(new DummyAccount(RepoManager.getRepoManager().getDummyClientRepo().getClients().get(0),4512.47));
        this.accounts.add(new DummyAccount(RepoManager.getRepoManager().getDummyClientRepo().getClients().get(1),0.00));
        this.accounts.add(new DummyAccount(RepoManager.getRepoManager().getDummyClientRepo().getClients().get(3),-1.00));
        this.accounts.add(new DummyAccount(RepoManager.getRepoManager().getDummyClientRepo().getClients().get(0),245698.68));
        this.accounts.add(new DummyAccount(RepoManager.getRepoManager().getDummyClientRepo().getClients().get(5),85.90));
        this.accounts.add(new DummyAccount(RepoManager.getRepoManager().getDummyClientRepo().getClients().get(5),125.35));
        this.accounts.add(new DummyAccount(RepoManager.getRepoManager().getDummyClientRepo().getClients().get(5),9586.23));

        this.accounts.get(0).addAuthorizedClient(RepoManager.getRepoManager().getDummyClientRepo().getClients().get(1));
        this.accounts.get(0).addAuthorizedClient(RepoManager.getRepoManager().getDummyClientRepo().getClients().get(2));
        this.accounts.get(5).addAuthorizedClient(RepoManager.getRepoManager().getDummyClientRepo().getClients().get(0));
    }

    public List<DummyAccount> getAccounts() {
        return accounts;
    }
}
