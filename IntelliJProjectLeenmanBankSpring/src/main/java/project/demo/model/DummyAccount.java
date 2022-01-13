package project.demo.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class DummyAccount implements Comparable<DummyAccount> {
    // TODO: delete after testing

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountNumber;
    @ManyToOne
    @JoinColumn(name = "accountHolder_id",nullable = false)
    private DummyClient accountHolder;
    private double balance;

    @ManyToMany()
    @JoinTable(
            name = "authorized_clients",
            joinColumns = @JoinColumn(name = "account"),
            inverseJoinColumns = @JoinColumn(name = "authorizedClients"))
    private Set<DummyClient> authorizedClients;

    public DummyAccount(DummyClient accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.authorizedClients = new HashSet<>();
    }

    public void addAuthorizedClient(DummyClient authorizedClient){
        this.authorizedClients.add(authorizedClient);
        authorizedClient.addAuthorizedAccount(this);
    }

    public Set<DummyClient> getAuthorizedClients() {
        return authorizedClients;
    }

    public void setAuthorizedClients(Set<DummyClient> authorizedClients) {
        this.authorizedClients = authorizedClients;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public DummyClient getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountHolder(DummyClient accountHolder) {
        this.accountHolder = accountHolder;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DummyAccount that = (DummyAccount) o;
        return Objects.equals(accountNumber, that.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }

    @Override
    public String toString() {
        return "DummyAccount{" +
                "accountNumber=" + accountNumber +
                ", accountHolder=" + accountHolder +
                ", balance=" + balance +
                '}';
    }

    @Override
    public int compareTo(DummyAccount o) {
        return this.accountNumber - o.getAccountNumber();
    }
}
