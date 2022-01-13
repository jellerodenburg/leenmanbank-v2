package project.demo.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class DummyClientPerson extends DummyClient{
    // Dummy data for testing
    // TODO: remove when working + read from DB/IRepo

    private String address;

    public DummyClientPerson(String name, String somethingExtra, String address) {
        super(name, somethingExtra);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
