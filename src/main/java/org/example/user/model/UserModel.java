package org.example.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserModel {

    private String id;

    @JsonProperty(value = "first_name")
    private String firstName;

    private String lastName;


    public UserModel(String id, String name) {
        this.id = id;
        this.firstName = name;
    }

    public UserModel(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
