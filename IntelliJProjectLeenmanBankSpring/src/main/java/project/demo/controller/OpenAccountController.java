package project.demo.controller;

import project.demo.model.DummyClient;
import org.springframework.web.bind.annotation.*;
import project.demo.repositories.RepoManager;

import java.util.List;

@RestController
public class OpenAccountController {
    List<DummyClient> clients = RepoManager.getRepoManager().getDummyClientRepo().getClients();

    @RequestMapping(value = "/testmethodeget", method = RequestMethod.GET)
    public String test() {
        return "test";
    }

        @RequestMapping(value = "/dummyclientrepo", method = RequestMethod.GET)
    public @ResponseBody List<DummyClient> getAllClients(){
        System.out.println("clients found");
        return this.clients;
    }

    @RequestMapping(value = "/html/openAccount/openAccountChooseType.html/sout", method = RequestMethod.GET)
    public void test2() {
        System.out.println("test in console");
    }

    @PostMapping("/post")
    public String test3(@RequestBody DummyClient newClient) {
        clients.add(newClient);
        return "Hello " + newClient.getName() + ", you're client nr. " + newClient.getId();
    }
}
