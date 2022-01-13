package project.demo.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class DummyClientPersonEmployee extends DummyClientPerson{
    // Dummy data for testing
    // TODO: remove when working + read from DB/IRepo

    private String department;

    public DummyClientPersonEmployee(String name, String somethingExtra, String address, String department) {
        super(name, somethingExtra, address);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
