package project.demo.model;

import java.util.Date;

public class Employee extends Person {
    //region ATTRIBUTES
    private JobTitle jobTitle;
    //endregion

    //region CONSTRUCTOR
    public Employee(Long id, Login login, ClientDetails contactDetails, PersonDetails personDetails, JobTitle jobTitle) {
        super(id, login, contactDetails, personDetails);
        this.jobTitle = jobTitle;
    }

    //endregion

    //region METHODS

    //endregion

    //region GETTERS & SETTERS

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }

    //endregion

    //region TOSTRING, HASH, EQUALS, COMPARE
    @Override
    public String toString() {
        return super.toString() + "Employee{" +
                "jobTitle=" + jobTitle +
                '}';
    }

    //endregion
}
