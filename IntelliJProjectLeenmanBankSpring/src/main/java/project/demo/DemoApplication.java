package project.demo;

import project.demo.model.DummyAccount;
import project.demo.model.DummyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import project.demo.repositories.*;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    public IDummyClientRepo dummyClient;
    @Autowired
    public IDummyAccountRepo dummyAccount;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Load data into DB
        // Load clients
        DummyClientRepo d = new DummyClientRepo();
        dummyClient.saveAll(d.getClients());

        // print all dummy clients
        System.out.println("Clients in DB");
        for (DummyClient client : dummyClient.findAll()             ) {
            System.out.println(client);
        }

        // add dummy client
        dummyClient.save(new DummyClient("Jeroen"));

        // print all dummy clients
        System.out.println("Clients in DB after adding one");
        for (DummyClient client : dummyClient.findAll()             ) {
            System.out.println(client);
        }

        // Load accounts
        DummyAccountRepo2 ac = new DummyAccountRepo2();

        for (DummyAccount account:ac.getAccounts()             ) {
            System.out.println(account);
            dummyAccount.save(account);
        }

        // print all dummy accounts
        System.out.println("Acounts in DB");
        for (DummyAccount account : dummyAccount.findAll()             ) {
            System.out.println(account);
        }

    }
}
