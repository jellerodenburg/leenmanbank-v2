package project.demo.repositories;

import java.util.ArrayList;
import java.util.List;

import project.demo.model.*;

public class DummyClientRepo {
    // Dummy data for testing
    // TODO: remove when working + read from DB/IRepo

    //    Person person = new Person("lbr","123","raf@hot.com","dorpstraat",1,
//            null, "1234AB","Eindhoven",123456789,"ralf","Wingen",
//            new Date(1986,5,13));
//    Company company = new Company("wingworld","123","user@wing.com","dorpstraat",2,
//            "bis", "1234AB","Eindhoven",1234567890,"WingWorld Inc.",
//            Sector.CULTURE_SPORTS_RECREATION);
//    Employee employee = new Employee("little_Baby!","123","kili@hot.com","dorpstraat",9,
//            "a", "1234AB","Aarle-Rixtel",123456780,"Kilian","Wingen",
//            new Date(2021,10,31),JobTitle.ACCOUNT_MANAGER);
    private List<DummyClient> clients;

    public DummyClientRepo() {
        this.clients = new ArrayList<>();
        clients.add(new DummyClient("Polly", "Ik ben een nieuwe klant"));
        clients.add(new DummyClientCompany("Winnie", "Ik heb een business account geopened", Sector.CULTURE_SPORTS_RECREATION));
        clients.add(new DummyClientCompany("Harry", "Ik ben een ben een zakelijke klant", Sector.AGRICULTURE_HORTICULTURE));
        clients.add(new DummyClientPerson("Lucas", "Ik ben een particuliere klant","Dorpstraat 1"));
        clients.add(new DummyClientCompany("Mary", "Ik ben een multinational", Sector.ENERGY_WATER_ENVIRONMENT));
        clients.add(new DummyClientPerson("Jane", "Ik ben een particuliere klant","Kerkplein 1"));
        clients.add(new DummyClientCompany("Kim", "Ik ben een multinational", Sector.HEALTHCARE));
        clients.add(new DummyClientCompany("Luna", "Ik ben een ben een zakelijke klant", Sector.ENERGY_WATER_ENVIRONMENT));
        clients.add(new DummyClientPerson("Sam", "Ik ben een particuliere klant",""));
        clients.add(new DummyClientPersonEmployee("Sammy", "Ik ben een werknemer","Putgraaf 6","HR"));
        clients.add(new DummyClient("Noel", "Ik heb een account geopened"));
        clients.add(new DummyClientPerson("John", "Ik ben een particuliere klant","Kleistraat 30a"));
        clients.add(new DummyClientCompany("Kimberly", "Ik ben ben een zakelijke klant", Sector.HEALTHCARE));
        clients.add(new DummyClientCompany("Ash", "Ik ben een multinational", Sector.FINANCE));
        clients.add(new DummyClientCompany("Ricki", "Ik ben een multinational", Sector.HOSPITALITY));
        clients.add(new DummyClient("Mark", "Hoi,hoi"));
        clients.add(new DummyClientPersonEmployee("Micky", "Ik ben een werknemer","Putgraaf 8","Finance"));
        clients.add(new DummyClientPerson("ralf", "Ik ben een particuliere klant","Molenweg 91"));
        clients.add(new DummyClientPersonEmployee("robin", "Ik ben een werknemer","Molenstraat 89","HR"));
        clients.add(new DummyClientCompany("Suze", "Ik heb een multinational en ben een zakelijke klant", Sector.ICT_AND_MEDIA));
    }

    public List<DummyClient> getClients() {
        return clients;
    }

}
