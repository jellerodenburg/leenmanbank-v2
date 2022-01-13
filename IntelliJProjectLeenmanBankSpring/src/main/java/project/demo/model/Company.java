package project.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Company extends AbstractClient {
    //region ATTRIBUTES
    private CompanyDetails companyDetails;
    private Employee accountManager;
    private int registrationCodePinTerminal;
    //endregion

    //region CONSTRUCTOR
    public Company(Long id, Login login, ClientDetails contactDetails, CompanyDetails companyDetails) {
        super(id, login, contactDetails);
        // Check if CoC exists, if so, return existing Company
        if (getAllcoCNumber().contains(id)) {
            System.out.println("Dit bedrijf bestaat al.");
            //TODO do something if company exists
        } else {
            this.companyDetails = companyDetails;
            Account account = new Account(this, AccountType.SMALL_BUSINESS);
        }
    }
    //endregion

    //region METHODS

    //endregion

    //region Helper Methods (private)
    private List<Long> getAllcoCNumber() {
        List<Long> numbers = new ArrayList<>();

        // Get all BSN from DAO/Repo
//        for (Integer coc : ?? ){
//            numbers.add(coc);
//        }
        //TODO

        return numbers;
    }
    //endregion

    //region GETTERS & SETTERS

    public CompanyDetails getCompanyDetails() {
        return companyDetails;
    }

    public void setCompanyDetails(CompanyDetails companyDetails) {
        this.companyDetails = companyDetails;
    }

    public Employee getAccountManager() {
        return accountManager;
    }

    public void setAccountManager(Employee accountManager) {
        this.accountManager = accountManager;
    }

    public int getRegistrationCodePinTerminal() {
        return registrationCodePinTerminal;
    }

    public void setRegistrationCodePinTerminal(int registrationCodePinTerminal) {
        this.registrationCodePinTerminal = registrationCodePinTerminal;
    }

    //endregion

    //region TOSTRING, HASH, EQUALS, COMPARE

    @Override
    public String toString() {
        return super.toString() + "Company{" +
                "companyDetails=" + companyDetails +
                ", accountManager=" + accountManager +
                ", registrationCodePinTerminal=" + registrationCodePinTerminal +
                '}';
    }

    //endregion
}
