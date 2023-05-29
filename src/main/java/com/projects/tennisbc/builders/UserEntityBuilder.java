package com.projects.tennisbc.builders;

import com.projects.tennisbc.repositories.entities.UserEntity;

import java.util.UUID;

public class UserEntityBuilder {

    private UUID id;
    private String firstName;
    private String lastName;
    private String password;

    public UserEntityBuilder withId(UUID id) {
        this.id = id;
        return this;
    }
    public UserEntityBuilder witFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
    public UserEntityBuilder wiLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    public UserEntityBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserEntity build() {
        UserEntity user = new UserEntity();
        return user;
    }
}
