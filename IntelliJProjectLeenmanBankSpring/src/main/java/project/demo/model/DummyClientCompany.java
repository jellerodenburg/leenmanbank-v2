package project.demo.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class DummyClientCompany extends DummyClient{
    // Dummy data for testing
    // TODO: remove when working + read from DB/IRepo

    @Enumerated(EnumType.STRING) // Sets the String value in DB, default = .ORDINAL (int value in DB)
    private Sector sector;

    public DummyClientCompany(String name, String somethingExtra, Sector sector) {
        super(name, somethingExtra);
        this.sector = sector;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }
}
