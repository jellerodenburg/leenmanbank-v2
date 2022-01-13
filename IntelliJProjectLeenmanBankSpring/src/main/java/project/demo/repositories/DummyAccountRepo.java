package project.demo.repositories;


import org.springframework.stereotype.Service;
import project.demo.model.AccountType;
import project.demo.model.DummyAccount;

import java.util.List;
import java.util.Random;

@Service
public class DummyAccountRepo {
    private static String[] accountNr;
    //            {"NL01LEEN050958749",
//                    "NL01LEEN014504865",
//                    "NL06LEEN01052114778",
//                    "NL08LEEN4588766214",
//                    "NL02LEEN133654284"};
    private static double[] balance;
    private static final AccountType[] types = {
            AccountType.INTERNAL,
            AccountType.CONSUMER,
            AccountType.LOANS,
            AccountType.TRADING,
            AccountType.SMALL_BUSINESS};

    private List<DummyAccount> dummyAccountList;

    private int generateRandomPinCode() {
        Random randomNumber = new Random();
        return randomNumber.nextInt(99999);
    }

    private String generateRandomBankNumbers() {
        String bankNumber = "NL";
        String middle = "LEEN";

        Random rand = new Random();
        for (int i = 0; i < 2; i++) {
            int n = rand.nextInt(10);
            bankNumber += Integer.toString(n);
        }
        bankNumber += middle;

        for (int i = 0; i < 9; i++) {
            int n = rand.nextInt(10);
            bankNumber += Integer.toString(n);
        }
        return bankNumber;
    }

    public void generateRandomAccount(int n,double balance){
//        Random r = new Random();
//        for (int i = 0; i < n; i++) {
//            dummyAccountList.add(new DummyAccount
//                    (this.generateRandomBankNumbers(),
//                            balance,types[r.nextInt(types.length)],
//                            this.generateRandomPinCode()));
//        }
    }

    public void generateRandomBalance(){

    }

    //CRUD
    void create(DummyAccount dummyAccount){
        dummyAccountList.add(dummyAccount);
    }

    void update(DummyAccount dummyAccount){
    }

    void delete(DummyAccount dummyAccount){
        dummyAccountList.remove(dummyAccount);
    }

}