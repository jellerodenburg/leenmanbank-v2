package project.demo.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity                     // saves class in database
@NoArgsConstructor          // generates no arg constructor
@AllArgsConstructor         // generates all arg constructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)   // creates single table of this class & all child classes
@DiscriminatorColumn(name="type_of_account")
public class DummyClient implements Comparable<DummyClient>{
    // Dummy data for testing
    // TODO: remove when working + read from DB/IRepo

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment of Id field in DB
    private Integer id;

    private static int lastId;
    private String name;
    private String somethingExtra;

    @OneToMany(mappedBy = "accountHolder")
    private Set<DummyAccount> dummyAccounts;

    @ManyToMany(mappedBy = "authorizedClients")
    private Set<DummyAccount> authorizedAccounts;

    public DummyClient(String name, String somethingExtra) {
        this.id = ++lastId;
        this.name = name;
        this.somethingExtra = somethingExtra;
        this.authorizedAccounts = new HashSet<>();
    }

    public DummyClient(String name){
        this(name,"I'm a client");
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSomethingExtra() {
        return somethingExtra;
    }

    public Set<DummyAccount> getDummyAccounts() {
        return dummyAccounts;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSomethingExtra(String somethingExtra) {
        this.somethingExtra = somethingExtra;
    }

    public void setDummyAccounts(Set<DummyAccount> dummyAccounts) {
        this.dummyAccounts = dummyAccounts;
    }

    public Set<DummyAccount> getAuthorizedAccounts() {
        return authorizedAccounts;
    }

    public void addAuthorizedAccount(DummyAccount authorizedAccount){
        this.authorizedAccounts.add(authorizedAccount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DummyClient that = (DummyClient) o;
        return id == that.id;
    }

    @Override
    public int compareTo(DummyClient o) {
        return this.id - o.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "DummyClient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", somethingExtra='" + somethingExtra + '\'' +
                '}';
    }

}
