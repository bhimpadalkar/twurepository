package com.twu.biblioteca.user;

public class UserCredentials {
    private String libraryNumber;
    private String password;

    public UserCredentials(String libraryNumber, String password){
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }
}
