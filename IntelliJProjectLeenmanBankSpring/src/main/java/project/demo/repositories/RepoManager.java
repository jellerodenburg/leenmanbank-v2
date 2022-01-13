package project.demo.repositories;

import project.demo.model.AbstractClient;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.AbstractClientRepo;

/**
 * Singleton class for using different repositories
 */
public class RepoManager {
    //region ATTRIBUTES
    private static RepoManager repoManager;
    @Autowired
    private AbstractClientRepo abstractClientRepo;
    @Autowired
    private DummyClientRepo dummyClientRepo;

    //endregion

    // CONSTRUCTOR
    private RepoManager(){

    }

    //region METHODS
    public boolean containsAbstractClient(String username){
        return abstractClientRepo.findAbstractClientByUsername(username);
    }

    public AbstractClient getAbstractClientByUsername(String username){
        return abstractClientRepo.getAbstractClientByUsername(username);
    }
    //endregion

    //region GETTERS & SETTERS
    public static RepoManager getRepoManager(){
        if (repoManager == null){
            repoManager = new RepoManager();
        }
        return repoManager;
    }

    public DummyClientRepo getDummyClientRepo() {
        if (dummyClientRepo == null){
            dummyClientRepo = new DummyClientRepo();
        }
        return dummyClientRepo;
    }
    //endregion
}
