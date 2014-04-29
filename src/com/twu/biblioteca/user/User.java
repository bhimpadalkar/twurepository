package com.twu.biblioteca.user;

import com.twu.biblioteca.menu.Displayable;

public class User implements Displayable{
    private UserCredentials credentials;
    private String userName;
    private String email;
    private String phoneNumber;

    public User(String libraryNumber, String userName, String password, String email, String phoneNumber) {
        if(isLibraryNumberValid(libraryNumber))
            this.credentials = new UserCredentials(libraryNumber,password);
        else
            throw new IllegalArgumentException("Library Number doesn't have valid format");

        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    private boolean isLibraryNumberValid(String libraryNumber) {
        return libraryNumber.matches("[0-9]{3}-[0-9]{4}");
    }

    public UserCredentials getCredentials(){
        return this.credentials;
    }

    @Override
    public String getDisplayText() {
        return ("User Name : " + this.userName + "\nEmail : " + this.email + "\nPhone Number : " + this.phoneNumber);
    }
}
