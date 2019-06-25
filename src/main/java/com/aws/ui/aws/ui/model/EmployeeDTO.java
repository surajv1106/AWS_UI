package com.aws.ui.aws.ui.model;

public class EmployeeDTO {


    private static final long serialVersionUID = -2343243243242432341L;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private long id;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    private String firstName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    private String lastName;

    protected EmployeeDTO() {
    }

    public EmployeeDTO(String firstName, String lastName, String organisation, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.organisation=organisation;
        this.email=email;
    }
//Setters, getters and constructors


    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }


    private String organisation;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    private String email;

}
