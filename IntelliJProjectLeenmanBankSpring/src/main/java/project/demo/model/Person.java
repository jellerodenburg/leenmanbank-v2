package project.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Person extends AbstractClient {
    //region ATTRIBUTES
    private PersonDetails personDetails;
    //endregion

    //region CONSTRUCTOR

    /**
     * Constructor for creating a customer of LeenmanBank containing login in, personal and contact details.
     * <p>
     * //     * @param username            Username to log in on the online account
     * //     * @param password            Password to log in on the online account
     * //     * @param email               Email address on which the account/customer are registered
     * //     * @param street              Street name of customer
     * //     * @param houseNumber         House number of customer
     * //     * @param houseNumberAddition House number addition of customer
     * //     * @param zipCode             Zip code of customer
     * //     * @param city                City of customer
     * //     * @param SSN                 Social security number of customer
     * //     * @param firstName           First name of customer
     * //     * @param lastName            Last name of customer
     * //     * @param dateOfBirth         Date of birth of customer
     *
     * @should Create a valid person with all above details
     * @should Check if the username is unique
     * @should Check if the password has at least 2 characters
     * @should Throw illegal argument exception if the password has less than 2 characters
     * @should Not create the Person if the password has less than 2 characters
     * @should Check if the person is already registered (same BSN) and not create a new instance of Person when so
     * but return existing one
     */
    public Person(Long id, Login login, ClientDetails contactDetails, PersonDetails personDetails) {
        super(id, login, contactDetails);
        // Check if username exists, if so, return existing Person
        if (getAllSSN().contains(id)) {
            System.out.println("Deze persoon bestaat al.");
            //TODO
        } else {
            // If BSN is unique, create new Person
            this.personDetails = personDetails;
            Account account = new Account(this, AccountType.CONSUMER);
        }
    }

    //endregion

    //region METHODS

    //endregion

    //region Helper Methods (private)
    private List<Long> getAllSSN() {
        List<Long> numbers = new ArrayList<>();

        // Get all BSN from DAO/Repo
//        for (Integer bsn : ?? ){
//            numbers.add(bsn);
//        }
        //TODO

        return numbers;
    }
    //endregion

    //region GETTERS & SETTERS

    public PersonDetails getPersonDetails() {
        return personDetails;
    }

    public void setPersonDetails(PersonDetails personDetails) {
        this.personDetails = personDetails;
    }

    //endregion

    //region TOSTRING, HASH, EQUALS, COMPARE

    @Override
    public String toString() {
        return super.toString() + "Person{" +
                "personDetails=" + personDetails +
                '}';
    }

//endregion
}
