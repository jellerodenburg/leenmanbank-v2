package project.demo.model;

import java.util.Objects;

public class CompanyDetails {
    private String name;
    private Sector sector;

    public CompanyDetails(String name, Sector sector) {
        this.name = name;
        this.sector = sector;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    @Override
    public String toString() {
        return "CompanyDetails{" +
                "name='" + name + '\'' +
                ", sector=" + sector +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyDetails that = (CompanyDetails) o;
        return Objects.equals(name, that.name) && sector == that.sector;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sector);
    }

}
