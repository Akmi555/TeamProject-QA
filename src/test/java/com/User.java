package com;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;


    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }


    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

     public String email() {
        return email;
    }

    public String password() {
        return password;
    }


}



